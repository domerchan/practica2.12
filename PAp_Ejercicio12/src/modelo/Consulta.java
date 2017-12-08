package modelo;

public class Consulta {

	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
		
	}

	public Consulta(Medico medico, Paciente paciente) {
		super();
		this.medico = medico;
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
