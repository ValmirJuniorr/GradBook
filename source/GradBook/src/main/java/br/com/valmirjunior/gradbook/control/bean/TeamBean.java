package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.Team;
import br.com.valmirjunior.gradbook.model.dao.TeamDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "teamBean")
@ViewScoped
public class TeamBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3089532980100515963L;
	
	@EJB
	private TeamDao teamDao;
	private Team team;
	private List<Team> teams;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Team> getTeams() {
		if (this.teams == null) {
			this.teams = this.teamDao.getList();
		}
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public void create() {
		this.teamDao.merge(this.team);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.teamDao.merge(this.team);
		this.setTeams(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Team team) {
		this.teamDao.remove(team);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setTeam(new Team());
		this.setTeams(null);
	}

}

