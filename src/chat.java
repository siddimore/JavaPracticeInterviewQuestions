/**
 * Created by MoreFamily on 3/9/2016.
 */
public class chat {

    boolean flag = false;

    public synchronized void question(String msg)
    {
        if(flag)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void answer(String msg)
    {
      if(!flag)
      {
          try
          {
              wait();
          }
          catch (InterruptedException ex)
          {
              ex.printStackTrace();
          }
      }

        System.out.println(msg);
        flag = false;
        notify();
    }

    class T1 implements Runnable {
        chat m;
        String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

        public T1(chat m1) {
            this.m = m1;
            new Thread(this, "Question").start();
        }

        public void run() {
            for (int i = 0; i < s1.length; i++) {
                m.question(s1[i]);
            }
        }
    }

    class T2 implements Runnable
    {
        chat m;

        String[] s2 = {"Hi","How are you?","I am also doing fine!"};

        public T2(chat m2)
        {
            this.m  = m2;
            new Thread(this, "Answer").start();
        }

        public void run()
        {
            for (int i = 0; i < s2.length; i++) {
                m.answer(s2[i]);
            }
        }
    }
}
