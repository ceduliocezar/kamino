package br.net.ops.kamino.gui.base;

/**
 * 
 * @author cedulio
 *
 */
public abstract class View {
	
	public void init(){
		initComponents();
	}

	protected abstract void initComponents();

}
