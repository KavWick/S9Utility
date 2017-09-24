/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.dispatcher.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 *
 * @author Kav
 */
public abstract class BaseView extends JFrame implements NativeKeyListener, WindowListener , NativeMouseInputListener{
    protected static String bindedActionKeys[] = new String[2];
    
    public BaseView(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.out.println("ERRORE CATCH");
        }
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
        GlobalScreen.removeNativeMouseMotionListener(this);
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.addNativeMouseListener(this);
    }
    
    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
         checkWetherActionOccured(nke);
    }
    
    @Override
    public abstract void nativeKeyPressed(NativeKeyEvent nke);

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {}

    @Override
    public void windowOpened(WindowEvent e) {
         
    }

    @Override
    public void windowClosing(WindowEvent e) {
         
    }

    @Override
    public void windowClosed(WindowEvent e) {
         
    }

    @Override
    public void windowIconified(WindowEvent e) {
         
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
         
    }

    @Override
    public void windowActivated(WindowEvent e) {
         
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
         
    }
    
     @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
    }

    @Override
    public abstract void nativeMousePressed(NativeMouseEvent nme);

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {
    }
    
    public abstract void checkWetherActionOccured(final NativeInputEvent e);
}
