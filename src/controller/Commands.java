package controller;

public enum Commands {
	INIT_SIMULATION("INIT_SIMULATION", "Iniciar la simulaci�n", "Inicia la simulaci�n", ""), 
	STOP_SIMULATION("STOP_SIMULATION", "Parar la simulaci�n", "Para la simualaci�n", ""), 
	GENERATE_REPORT("GENERATE_REPORT", "Generar reporte", "Genera reporte", ""), 
	CHANGE_SPEED("CHANGE_SPEED", "Cambiar velocidad", "Cambia la velocidad de simulaci�n", "");

	private String command;
	private String title;
	private String description;
	private String pathIcon;

	private Commands(String command, String title, String description, String pathIcon) {
		this.command = command;
		this.title = title;
		this.description = description;
		this.pathIcon = pathIcon;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPathIcon() {
		return pathIcon;
	}

	public void setPathIcon(String pathIcon) {
		this.pathIcon = pathIcon;
	}

}
