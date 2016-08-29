package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.Collaborator;
import br.com.valmirjunior.gradbook.model.dao.CollaboratorDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "collaboratorBean")
@ViewScoped
public class CollaboratorBean implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8711590317339709890L;
	
	@EJB
	private CollaboratorDao collaboratorDao;
	private Collaborator collaborator;
	private List<Collaborator> collaborators;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public List<Collaborator> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}

	public void create() {
		this.collaboratorDao.merge(this.collaborator);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.collaboratorDao.merge(this.collaborator);
		this.setCollaborators(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Collaborator collaborator) {
		this.collaboratorDao.remove(collaborator);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setCollaborator(new Collaborator());
		this.setCollaborators(null);
	}

}
