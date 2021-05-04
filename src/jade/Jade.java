/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import jade.core.Agent;

/**
 *
 * @author ratedstark
 */
public class Jade extends Agent {
    SimpleLinearRegression simple = new SimpleLinearRegression();
    @Override
    public void setup(){
        simple.formula();
    }
}
