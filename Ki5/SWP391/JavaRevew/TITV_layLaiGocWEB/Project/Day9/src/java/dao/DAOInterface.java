/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface DAOInterface<T> {
    public int insert(T t);
    public int Update(T t);
    public int Delete(T t);
    public ArrayList<T> selectAll();
    public T selectById(int t);
    public ArrayList<T> selectByCondition(String condition);
}
