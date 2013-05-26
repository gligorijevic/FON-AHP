/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Djordje Gligorijevic
 */
public class DBBroker {
    
    private DBBroker() {
    }
    
    public static DBBroker getInstance() {
        return DBBrokerHolder.INSTANCE;
    }
    
    private static class DBBrokerHolder {

        private static final DBBroker INSTANCE = new DBBroker();
    }
}
