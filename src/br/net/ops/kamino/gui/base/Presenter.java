package br.net.ops.kamino.gui.base;

/**
 * 
 * @author cedulio
 *
 */
public abstract class Presenter {
	
	private View view;
	
	public void init(){
		createView();
		initView();
	}

	private void createView() {
		setView(createNewInstanceView());
		onCreateNewView(getView());
	}

	private View getView() {
		return view;
	}

	private void onCreateNewView(View newViewInstance) {
		
	}

	private void setView(View view) {
		this.view = view;
	}

	private void initView() {
		getView().init();
	}

	protected abstract View createNewInstanceView();

}
