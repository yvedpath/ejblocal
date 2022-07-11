package com;
import javax.ejb.Stateful;
@Stateful
public class AB implements AR
{
        public int add(int a,int b)
        {
                return a+b;
        }
}

