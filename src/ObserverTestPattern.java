/**
 * Created by MoreFamily on 4/10/2016.
 */
public class ObserverTestPattern{

    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        MyObserver obj1 = new MyTopicSubscriber("Obj1");
        MyObserver obj2 = new MyTopicSubscriber("Obj2");
        MyObserver obj3 = new MyTopicSubscriber("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message");
    }

}