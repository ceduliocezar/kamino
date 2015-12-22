package br.net.ops.kamino.ui.base;

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
