package controller;

public enum Commands {
	INIT_SIMULATION("INIT_SIMULATION", "Iniciar la simulación", "Inicia la simulación",
			"/images/playIcon.png"), STOP_SIMULATION("STOP_SIMULATION", "Parar la simulación", "Para la simualación",
					"/images/stopIcon.png"), GENERATE_REPORT("GENERATE_REPORT", "Generar reporte", "Genera reporte",
							"/images/reportIcon.png"), SHOW_ABOUT("SHOW_ABOUT", "Acerca de", "Datos de la aplicación",
									""), RESET_SIMULATION("RESET_SIMULATION", "Reiniciar simulación",
											"Reinicia todos los elemento de la simulación", "/images/resetIcon.png");
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

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPathIcon() {
		return pathIcon;
	}

}
