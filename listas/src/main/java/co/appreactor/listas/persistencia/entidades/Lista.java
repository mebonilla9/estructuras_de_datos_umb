package co.appreactor.listas.persistencia.entidades;

public class Lista<T> {

  private Nodo<T> inicio;
  private int tamano;

  public Lista() {
    this.tamano = 0;
  }

  public void agregarAlInicio(Nodo<T> item){
    if (item == null){
      System.out.println("Debe agregar un nuevo item");
      return;
    }
    this.tamano++;
    if (getInicio() != null){
      item.setSiguiente(getInicio());
    }
    setInicio(item);
  }

  public void agregarAlFinal(Nodo<T> item){
    Nodo<T> temp = this.inicio;
    while (temp.getSiguiente() != null){
      temp = temp.getSiguiente();
    }
    temp.setSiguiente(item);
  }


  public Nodo<T> getInicio() {
    return inicio;
  }

  public void setInicio(Nodo<T> inicio) {
    this.inicio = inicio;
  }

  public void imprimirLista(Nodo<T> item){
    if (item == null) {
      item = this.getInicio();
    }
    System.out.println(item.getDato());
    if (item.getSiguiente() != null) {
      imprimirLista(item.getSiguiente());
    }
  }

  public int getTamano(){
    return this.tamano;
  }
}
