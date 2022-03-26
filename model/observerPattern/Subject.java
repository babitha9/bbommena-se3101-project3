package model.observerPattern;

public interface Subject {
    public void addLisiner(Observer ob);

    public void deleteLisiner(Observer ob);

    public void notifyEvent( );
}
