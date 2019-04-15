import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Klasa w kt�rej generowany jest panel Lista Pacjent�w wraz z tabel�
 */

public class Tabela implements ActionListener {

	static JButton bDodaj, bUsu�;
	static JTable tabela;
	private JScrollPane spDanePacjenta;
	private JCheckBox cbBadanie;
	private Frame frame;
	Object[] row = new Object[5];
	JTable tListaPacjent�w;
	DefaultTableModel model;
	JPanel paneltabela;

	// getter i setter dla panelu
	public JPanel getPaneltabela() {
		return paneltabela;
	}

	public void setPaneltabela(JPanel paneltabela) {
		this.paneltabela = paneltabela;
	}

	public Tabela(Frame frame) {
		this.frame = frame;

		// Panel Badanie i jego komponenty
		paneltabela = new JPanel();
		paneltabela.setBackground(Color.GREEN);
		paneltabela.setLayout(null);

		paneltabela.setBorder(BorderFactory.createTitledBorder("Lista Pacjent�w"));
		paneltabela.setBounds(405, 50, 1050, 700);

		Object[] Dane = { "Imi� i nazwisko", "P�e�", "Pesel", "Ubezpieczenie", "Badanie" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(Dane);

		// ustawianie wlasciwosci paneli
		tabela = new JTable(model) {
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return Boolean.class;
				default:
					return Object.class;
				}
			}
		};

		tabela.setBackground(Color.WHITE);
		tabela.setForeground(Color.BLACK);
		Font font = new Font("Times New Roman", 1, 16);
		tabela.setFont(font);
		tabela.setRowHeight(30);

		bDodaj = new JButton("Dodaj");
		paneltabela.add(bDodaj);
		bDodaj.setBounds(50, 630, 100, 25);
		bDodaj.addActionListener(this);

		bUsu� = new JButton("Usu�");
		paneltabela.add(bUsu�);
		bUsu�.setBounds(150, 630, 100, 25);
		bUsu�.setEnabled(false);
		bUsu�.addActionListener(this);

		// dodanie tabeli do panelu
		spDanePacjenta = new JScrollPane(tabela);
		spDanePacjenta.setBounds(50, 30, 900, 600);
		paneltabela.add(spDanePacjenta);

		// Obs�uga zdarzenia naci�ni�cia przycisku myszy
		tabela.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				tabela.setDefaultEditor(Object.class, null);
				tabela.setDefaultEditor(Boolean.class, null);

				// dobranie si� do wiersza tabeli
				int i = tabela.getSelectedRow();

				if (i == -1) {
					tabela.clearSelection();
				} else {
					String s1 = DanePacjenta.lista.get(i).getP�e�();

					bDodaj.setEnabled(false);
					DanePacjenta.tfImie.setEnabled(true);
					DanePacjenta.lImie.setEnabled(true);
					DanePacjenta.tfNazwisko.setEnabled(true);
					DanePacjenta.lNazwisko.setEnabled(true);
					DanePacjenta.rbM�czyzna.setEnabled(true);
					DanePacjenta.rbKobieta.setEnabled(true);
					DanePacjenta.tfPESEL.setEnabled(true);
					DanePacjenta.lP�e�.setEnabled(true);
					DanePacjenta.lPESEL.setEnabled(true);
					DanePacjenta.cbUbezpieczenie.setEnabled(true);
					DanePacjenta.lUbezpieczenie.setEnabled(true);
					DanePacjenta.bZapisz.setEnabled(true);
					DanePacjenta.bAnuluj.setEnabled(true);
					Badanie.tfHDL.setEnabled(true);
					Badanie.lHDL.setEnabled(true);
					Badanie.tfLDL.setEnabled(true);
					Badanie.lLDL.setEnabled(true);
					Badanie.tfTG.setEnabled(true);
					Badanie.lTG.setEnabled(true);
					Badanie.bZapisz2.setEnabled(true);
					Badanie.bAnuluj2.setEnabled(true);
					Badanie.lData.setEnabled(true);
					Badanie.sData.setEnabled(true);

					DanePacjenta.tfImie.setText(DanePacjenta.lista.get(i).getmImie());
					DanePacjenta.tfNazwisko.setText(DanePacjenta.lista.get(i).getmNazwisko());
					if (s1.contentEquals("M�czyzna")) {
						DanePacjenta.rbM�czyzna.setSelected(true);
					} else {
						DanePacjenta.rbKobieta.setSelected(true);
					}
					DanePacjenta.tfPESEL.setText(DanePacjenta.lista.get(i).getmPESEL());
					DanePacjenta.cbUbezpieczenie.setSelectedItem(DanePacjenta.lista.get(i).getUbezpieczenie());
					Badanie.tfHDL.setText(Integer.toString(DanePacjenta.lista.get(i).getHDL()));
					Badanie.tfLDL.setText(Integer.toString(DanePacjenta.lista.get(i).getLDL()));
					Badanie.tfTG.setText(Integer.toString(DanePacjenta.lista.get(i).getTG()));
					Badanie.sdmData.setValue(DanePacjenta.lista.get(i).getData());
				}
			}

		});

	}

	// metoda odpowiadaj�ca za dodanie pacjenta do listy, sprawdzaj�ca poprawno��
	// dodawania
	public void addPacjent(Pacjent p2) {
		int i = tabela.getSelectedRow();

		for (Pacjent P : DanePacjenta.lista) {
			if (i != -1) {
			} else if (DanePacjenta.tfPESEL.getText().equals(P.getmPESEL())) {
				JOptionPane.showMessageDialog(null, "Pacjent o tym numerze PESEL istnieje ju� w bazie.", "B��d zapisu",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		p2.checkPesel(DanePacjenta.tfPESEL.getText());

		if (i == -1) {
			DanePacjenta.lista.add(p2);
			Object[] wiersz = {
					DanePacjenta.lista.get(DanePacjenta.lista.size() - 1).getmImie() + " "
							+ DanePacjenta.lista.get(DanePacjenta.lista.size() - 1).getmNazwisko(),
					DanePacjenta.lista.get(DanePacjenta.lista.size() - 1).getP�e�(),
					DanePacjenta.lista.get(DanePacjenta.lista.size() - 1).getmPESEL(),
					DanePacjenta.lista.get(DanePacjenta.lista.size() - 1).getUbezpieczenie() };

			model.addRow(wiersz);
		} else {
			DanePacjenta.lista.set(i, p2);
			model.setValueAt(DanePacjenta.lista.get(i).getmImie() + " " + DanePacjenta.lista.get(i).getmNazwisko(), i,
					0);
			model.setValueAt(DanePacjenta.lista.get(i).getP�e�(), i, 1);
			model.setValueAt(DanePacjenta.lista.get(i).getmPESEL(), i, 2);
			model.setValueAt(DanePacjenta.lista.get(i).getUbezpieczenie(), i, 3);
		}

	}

	// Obs�uga zdarze�
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bDodaj) {
			tabela.clearSelection();
			bDodaj.setEnabled(false);

			DanePacjenta.tfImie.setEnabled(true);
			DanePacjenta.lImie.setEnabled(true);
			DanePacjenta.tfNazwisko.setEnabled(true);
			DanePacjenta.lNazwisko.setEnabled(true);
			DanePacjenta.rbM�czyzna.setEnabled(true);
			DanePacjenta.rbKobieta.setEnabled(true);
			DanePacjenta.tfPESEL.setEnabled(true);
			DanePacjenta.lP�e�.setEnabled(true);
			DanePacjenta.lPESEL.setEnabled(true);
			DanePacjenta.cbUbezpieczenie.setEnabled(true);
			DanePacjenta.lUbezpieczenie.setEnabled(true);
			DanePacjenta.bZapisz.setEnabled(true);
			DanePacjenta.bAnuluj.setEnabled(true);
			Badanie.tfLDL.setEnabled(false);
			Badanie.lLDL.setEnabled(false);
			Badanie.tfHDL.setEnabled(false);
			Badanie.lHDL.setEnabled(false);
			Badanie.tfTG.setEnabled(false);
			Badanie.lTG.setEnabled(false);
			Badanie.bZapisz2.setEnabled(false);
			Badanie.bAnuluj2.setEnabled(false);
			Badanie.lData.setEnabled(false);
			Badanie.sData.setEnabled(false);

		}

		if (source == bUsu�) {
			int i = tabela.getSelectedRow();
			if (i >= 0) {

				DanePacjenta.tfImie.setText(null);
				DanePacjenta.tfNazwisko.setText(null);
				DanePacjenta.tfPESEL.setText(null);
				DanePacjenta.bg.clearSelection();
				DanePacjenta.cbUbezpieczenie.setSelectedIndex(-1);
				Badanie.tfHDL.setText(null);
				Badanie.tfLDL.setText(null);
				Badanie.tfTG.setText(null);

				bUsu�.setEnabled(true);
				model.removeRow(i);

				DanePacjenta.lista.remove(i);

				bDodaj.setEnabled(true);
				Badanie.tfLDL.setEnabled(false);
				Badanie.lLDL.setEnabled(false);
				Badanie.tfHDL.setEnabled(false);
				Badanie.lHDL.setEnabled(false);
				Badanie.tfTG.setEnabled(false);
				Badanie.lTG.setEnabled(false);
				Badanie.bZapisz2.setEnabled(false);
				Badanie.bAnuluj2.setEnabled(false);
				Badanie.lData.setEnabled(false);
				Badanie.sData.setEnabled(false);

				DanePacjenta.tfImie.setText(null);
				DanePacjenta.tfNazwisko.setText(null);
				DanePacjenta.tfPESEL.setText(null);
				DanePacjenta.rbKobieta.setSelected(false);
				DanePacjenta.rbM�czyzna.setSelected(false);
				DanePacjenta.cbUbezpieczenie.setSelectedIndex(-1);
				DanePacjenta.tfImie.setEnabled(false);
				DanePacjenta.lImie.setEnabled(false);
				DanePacjenta.tfNazwisko.setEnabled(false);
				DanePacjenta.lNazwisko.setEnabled(false);
				DanePacjenta.rbM�czyzna.setEnabled(false);
				DanePacjenta.rbKobieta.setEnabled(false);
				DanePacjenta.tfPESEL.setEnabled(false);
				DanePacjenta.lP�e�.setEnabled(false);
				DanePacjenta.lPESEL.setEnabled(false);
				DanePacjenta.cbUbezpieczenie.setEnabled(false);
				DanePacjenta.lUbezpieczenie.setEnabled(false);
				DanePacjenta.bZapisz.setEnabled(false);
				DanePacjenta.bAnuluj.setEnabled(false);

				if (DanePacjenta.lista.isEmpty() == true) {
					bUsu�.setEnabled(false);
				}
			} else {
				bUsu�.setEnabled(false);
			}
		}
	}

}