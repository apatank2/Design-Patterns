package studentCoursesBackup.myTree;

public interface SubjectI {
public void RegisterObserver(ObserverI o);
public void notifyObservers(String Course,Operations Operation_Type);
public void RemoveObserver(ObserverI o);
}
