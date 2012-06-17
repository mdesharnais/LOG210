package hotel.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est très similaire à la classe java.util.Observable à quelques exception près :
 * 
 * <ul>
 * <li>Elle est templaté avec le type observé.</li>
 * <li>Elle utilise la classe hotel.util.Observer<T> au lieu de java.util.Observer.</li>
 * <li>Il n'est pas nécessaire d'appeler la méthode setChanged() avant notifyObservers().</li>
 * <li>Certaines fonctionnalités n'ont pas été implémentées puisque non nécessaires pour l'instant.</li>
 * <li>La méthode notifyObservers() est publique au lieu d'être protégée.</li>
 * </ul>
 * 
 * La raison pour laquelle la méthode notifyObservers() est publique est que cette classe n'est pas
 * faite pour que l'on en hérite. Elle est conçue pour être utilisé par composition un peu à la
 * manière d'une ArrayList<>. Une classe peut ainsi avoir plusieures listes d'observeurs qui sont
 * intéressés par des événements différents.
 * 
 * Pour un équivalent direct de la classe java.util.Observable, tournez-vous plutôt vers la classe
 * hotel.util.Observable<>.
 * 
 * @param <T>
 *            Le type de l'objet observé.
 */
public final class ConcreteObservable<T> {

    // --------------------------------------------------
    // Constructor(s)

    // --------------------------------------------------
    // Accessor(s)

    // --------------------------------------------------
    // Mutators(s)

    public void addObserver(Observer<T> observer) {
        data.add(observer);
    }

    // --------------------------------------------------
    // Method(s)

    public void notifyObservers(T obj) {
        for (Observer<T> observer : data)
            observer.update(obj);
    }

    // --------------------------------------------------
    // Attribute(s)

    List<Observer<T>> data = new ArrayList<Observer<T>>();
}
