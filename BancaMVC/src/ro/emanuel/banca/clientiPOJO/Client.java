package ro.emanuel.banca.clientiPOJO;

public class Client {
	private int id;
	private String nume;
	private String prenume;
	private String cont;
	private double sold;

	public Client() {
		super();
	}
	
	public Client(int id, String nume, String prenume, String cont, double sold) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.cont = cont;
		this.sold = sold;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCont() {
		return cont;
	}
    public void setCont(String cont) {
		this.cont = cont;
	}
	public void setSold(double sold) {
		this.sold = sold;
	}
	public double getSold() {
		return sold;
	}

	


}

