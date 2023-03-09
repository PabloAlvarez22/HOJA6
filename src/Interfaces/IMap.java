// Autor: Pablo Alvarez 221082

package Interfaces;
public interface IMap {
    public int lenght();
    public void orderByCategory();
    public void add(String name, String category) throws Exception;
    public String find(String name);
    public void printMap();
}
