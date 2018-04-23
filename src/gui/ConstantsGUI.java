package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ConstantsGUI {
	public final static String TITLE_APP = "Terminal Simulator";
	public final static String ICON_APP_PATH = "/images/iconApp.png";
	public final static String ICON_APP_PATH2 = "/images/iconApp2.png";
	public final static int SIZE_TICKET_OFFICE = 200;
	public final static int SIZE_PERSON = 20;
	public final static int WIDTH_ROAD = 50;
	public final static int HEIGHT_ROAD = 800;
	public final static String ICON_TICKET_OFFICE_PATH = "/images/ticketOfficeIcon.png";
	public final static String ICON_TICKET_OFFICE2_PATH = "/images/ticketOfficeIcon2.png";
	public final static String ICON_ENTRY_PATH = "/images/entryIcon.png";
	public final static String ICON_PERSON_PATH = "/images/personIcon.png";
	public final static String ICON_PERSON2_PATH = "/images/personIcon2.png";
	public final static String ROAD_IMAGE_PATH = "/images/road.png";
	public final static String ROAD2_IMAGE_PATH = "/images/road2.jpg";
	public final static Font FONT_TITLES = new Font("Impact", Font.PLAIN, 15);
	public final static Font FONT_TITLES2 = new Font("Impact", Font.PLAIN, 35);
	public final static Font FONT_BUS = new Font("Century", Font.PLAIN, 13);
	public final static Font FONT_REPORT = new Font("Century", Font.PLAIN, 20);
	public static final Dimension DIMENSION_COMBO_CONC = new Dimension(115, 50);
	public static final Dimension DIMENSION_SLIDER = new Dimension(115, 50);
	public final static Dimension DIMENSION_DIALOG_ABOUT = new Dimension(530, 275);
	public final static Dimension DIMENSION_DIALOG_TITLE = new Dimension(480, 50);
	public static final Dimension DIMENSION_TEXT_ABOUT = new Dimension(340, 180);
	public static final Dimension DIMENSION_IMAGE_ABOUT = new Dimension(128, 128);
	public static final Dimension DIMENSION_DIALOG_SPLASH = new Dimension(400, 400);
	public final static Color COLOR_BACK_APP = Color.decode("#736699");
	public static final Color COLOR_BACK_TERMINAL = Color.DARK_GRAY;
	public final static String TEXT_SIMULATION = "Simulación";
	public final static String TEXT_CONFIGURATION = "Configuración";
	public final static String TEXT_ABOUT_ = "Terminal Simulator. \nCreado por Andrés Felipe Flórez Caro"
			+ "\ncon la colaboración de:  Ing. Alexander Castro Romero - \n     Idea: Ángel Nicolás Méndez\n      Fabián Nicolás Ramos \nIngeniería de Sistemas y Computación.\n"
			+ "UPTC.  \n2018";
	public final static String NAME_TICKET_O = "Nombre de la taquilla";
	public final static String TICKETS_SOLD = "Tiquetes vendidos";
	public final static String TOTAL_INCOMES = "Total de ingresos";
	public static final String TEXT_CONCURRENCY = "Concurrencia: ";
	public static final String BUSES_DISPATCHED = "Buses despachados";
	public static final String TEXT_SPEED = "<html><br>Velocidad de </br><br>simulación: </br></html>";
	public static final String TOOLTIP_SLIDER = "Desliza para cambiar la velocidad de simulación";
	public static final String TEXT_PASSENGERS = "Pasajeros : ";
}
