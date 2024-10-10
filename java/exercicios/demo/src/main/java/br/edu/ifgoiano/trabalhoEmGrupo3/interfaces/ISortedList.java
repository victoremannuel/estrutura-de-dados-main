package br.edu.ifgoiano.trabalhoEmGrupo3.interfaces;

public interface ISortedList<T extends Comparable<?>> extends IList<T> {

  public void insert(T value);

}
