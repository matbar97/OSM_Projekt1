import java.util.Date;

/*
 * Klasa Pacjent
 */
public class Pacjent {

	private String mImie, mNazwisko, mPESEL, P�e�, Ubezpieczenie;
	private int HDL, LDL, TG;
	private Date data;

	// konstruktory
	public Pacjent() {

	}

	public Pacjent(String mImie, String mNazwisko, String mPESEL, String P�e�, String Ubezpieczenie, String HDL,
			String LDL, String TG, Date data) {
		super();
		this.mImie = mImie;
		this.mNazwisko = mNazwisko;
		this.mPESEL = mPESEL;
		this.P�e� = P�e�;
		this.Ubezpieczenie = Ubezpieczenie;
		this.HDL = 0;
		this.LDL = 0;
		this.TG = 0;
		this.data = Badanie.sdmData.getDate();
	}

	// gettery i settery
	public int getHDL() {
		return HDL;
	}

	public void setHDL(int hDL) {
		HDL = hDL;
	}

	public int getLDL() {
		return LDL;
	}

	public void setLDL(int lDL) {
		LDL = lDL;
	}

	public int getTG() {
		return TG;
	}

	public void setTG(int tG) {
		TG = tG;
	}

	public String getP�e�() {
		return P�e�;
	}

	public void setP�e�(String p�e�) {
		P�e� = p�e�;
	}

	public String getmImie() {
		return mImie;
	}

	public void setmImie(String mImie) {
		this.mImie = mImie;
	}

	public String getmNazwisko() {
		return mNazwisko;
	}

	public void setmNazwisko(String mNazwisko) {
		this.mNazwisko = mNazwisko;
	}

	public String getmPESEL() {
		return mPESEL;
	}

	public void setmPESEL(String mPESEL) {
		this.mPESEL = mPESEL;
	}

	public String getUbezpieczenie() {
		return Ubezpieczenie;
	}

	public void setUbezpieczenie(String ubezpieczenie) {
		Ubezpieczenie = ubezpieczenie;
	}

	// metody
	// metoda por�wnuj�ca pesele Pacjent�w
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Pacjent other = (Pacjent) obj;
		if (this.mPESEL == null) {
			if (other.mPESEL != null)
				return (false);
		} else if (!this.mPESEL.equals(other.mPESEL))
			return (false);
		return (true);
	}

	// metoda sprawdzaj�ca czy pesel jest prawid�owy
	public void checkPesel(String PESEL) {
		int count = 0;
		for (int i = 0, len = PESEL.length(); i < len; i++) {
			if (Character.isDigit(PESEL.charAt(i))) {
				count++;
			}
		}

	}

	@Override
	public String toString() {
		return "Pacjent [mImie=" + mImie + ", mNazwisko=" + mNazwisko + ", mPESEL=" + mPESEL + ", P�e�=" + P�e�
				+ ", Ubezpieczenie=" + Ubezpieczenie + "" + "Data" + data + "]";
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}