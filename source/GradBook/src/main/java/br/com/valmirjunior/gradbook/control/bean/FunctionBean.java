package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.Function;
import br.com.valmirjunior.gradbook.model.dao.FunctionDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "functionBean")
@ViewScoped
public class FunctionBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5473104684476729695L;
	
	@EJB
	private FunctionDao functionDao;
	private Function function;
	private List<Function> functions;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<Function> getFunctions() {
		if (this.functions == null) {
			this.functions = this.functionDao.getList();
		}
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public void create() {
		this.functionDao.merge(this.function);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.functionDao.merge(this.function);
		this.setFunctions(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Function function) {
		this.functionDao.remove(function);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setFunction(new Function());
		this.setFunctions(null);
	}

}
