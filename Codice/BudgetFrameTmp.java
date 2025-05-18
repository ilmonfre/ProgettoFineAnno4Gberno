        // Inizio pannello annuale

        buttonAggiungiAnnuale = new JButton();
        buttonImpostazioniAnnuale = new JButton();

        // Carica immagini per i bottoni
        ImageIcon iconaAggiungiAnnuale = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        ImageIcon iconaImpostazioniAnnuale = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));

        buttonAggiungiAnnuale.setIcon(iconaAggiungiAnnuale);
        buttonImpostazioniAnnuale.setIcon(iconaImpostazioniAnnuale);

        buttonAggiungiAnnuale.setOpaque(false);
        buttonAggiungiAnnuale.setContentAreaFilled(false);
        buttonAggiungiAnnuale.setBorderPainted(false);
        buttonAggiungiAnnuale.setFocusPainted(false);

        buttonImpostazioniAnnuale.setOpaque(false);
        buttonImpostazioniAnnuale.setContentAreaFilled(false);
        buttonImpostazioniAnnuale.setBorderPainted(false);
        buttonImpostazioniAnnuale.setFocusPainted(false);

        // Frame impostazioni
        frameImpostazioniAnnuale = new JFrame();
        frameImpostazioniAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImpostazioniAnnuale.setSize(250, 200);
        centraFrame(frameImpostazioniAnnuale);

        frameModificaAnnuale = new JFrame();
        frameModificaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModificaAnnuale.setSize(250, 200);
        centraFrame(frameModificaAnnuale);

        frameCreaAnnuale = new JFrame();
        frameCreaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCreaAnnuale.setSize(250, 200);
        centraFrame(frameCreaAnnuale);

        frameEliminaAnnuale = new JFrame();
        frameEliminaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEliminaAnnuale.setSize(250, 200);
        centraFrame(frameEliminaAnnuale);

        panelCreaAnnuale = new JPanel();
        panelImpostazioniAnnuale = new JPanel();
        panelEliminaAnnuale = new JPanel();
        panelModificaAnnuale = new JPanel();

        buttonModificaAnnuale = new RoundedBorderButton("Modifica", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonEliminaAnnuale = new RoundedBorderButton("Elimina", dark, dark, light, light, light, dark, 2, 20, 20);

        buttonModificaAnnuale.setPreferredSize(new Dimension(50, 30));
        buttonEliminaAnnuale.setPreferredSize(new Dimension(50, 30));

        buttonSiAnnuale = new RoundedBorderButton("Si", Color.decode("#be1327"), Color.decode("#be1327"), Color.white, Color.white, Color.white, Color.decode("#be1327"), 2, 20, 20);
        buttonNoAnnuale = new RoundedBorderButton("No", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonConfermaAnnuale = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textModificaAnnuale = new RoundedTextField(20, 30);
        labelCentraleAnnuale = new JLabel("Non è presente nessun budget");

        buttonConfCreaAnnuale = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textMaxAnnuale = new RoundedTextField(20, 30);
        panelSupCenAnnuale = new JPanel();
        aggiornaPannelloAnnuale();

        // Placeholder gestione per textModifica
        textModificaAnnuale.setBackground(Color.decode("#D3D3D3"));
        textModificaAnnuale.setForeground(Color.GRAY);
        textModificaAnnuale.setText(placeholder);

        textModificaAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModificaAnnuale.getText().equals(placeholder)) {
                    textModificaAnnuale.setText("");
                    textModificaAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModificaAnnuale.getText().isEmpty()) {
                    textModificaAnnuale.setForeground(Color.GRAY);
                    textModificaAnnuale.setText(placeholder);
                }
            }
        });

        // Placeholder gestione per textMax
        textMaxAnnuale.setBackground(Color.decode("#D3D3D3"));
        textMaxAnnuale.setForeground(Color.GRAY);
        textMaxAnnuale.setText(placeholder2);

        textMaxAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMaxAnnuale.getText().equals(placeholder2)) {
                    textMaxAnnuale.setText("");
                    textMaxAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMaxAnnuale.getText().isEmpty()) {
                    textMaxAnnuale.setForeground(Color.GRAY);
                    textMaxAnnuale.setText(placeholder2);
                }
            }
        });

        buttonConfCreaAnnuale.addActionListener(e -> {

            if (!budget.controlloNumero(textMaxAnnuale)) {
                JOptionPane.showMessageDialog(frameCreaAnnuale, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textMaxAnnuale.getText().equals("")) {
                JOptionPane.showMessageDialog(frameCreaAnnuale, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textMaxAnnuale.getText());
                budget.setMaxAnn(nuovoMax);
                aggiornaPannelloAnnuale();
                frameCreaAnnuale.dispose();
            }

            // Reset del JTextField
            textMaxAnnuale.setBackground(Color.decode("#D3D3D3"));
            textMaxAnnuale.setForeground(Color.GRAY);
            textMaxAnnuale.setText(placeholder2);
            textMaxAnnuale.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textMaxAnnuale.getText().equals(placeholder2)) {
                        textMaxAnnuale.setText("");
                        textMaxAnnuale.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textMaxAnnuale.getText().isEmpty()) {
                        textMaxAnnuale.setForeground(Color.GRAY);
                        textMaxAnnuale.setText(placeholder2);
                    }
                }
            });
        });

        JPanel panelTextAnnualeTmp = new JPanel();
        textMaxAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTextAnnualeTmp.add(textMax);

        JLabel labelAnnualeTmp = new JLabel("");
        JPanel panelVuotoAnnualeTmp = new JPanel();
        labelAnnualeTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoAnnualeTmp.add(labelTmp);

        JPanel panelButtonAnnualeTmp = new JPanel();
        buttonConfCreaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonAnnualeTmp.add(buttonConfCreaAnnuale);

        panelCreaAnnuale.setLayout(new GridLayout(3, 1));
        panelCreaAnnuale.add(panelTextAnnualeTmp);
        panelCreaAnnuale.add(panelVuotoAnnualeTmp);
        panelCreaAnnuale.add(panelButtonAnnualeTmp);

        frameCreaAnnuale.add(panelCreaAnnuale);

        buttonAggiungiAnnuale.addActionListener(e -> {
            centraFrame(frameCreaAnnuale);
            frameCreaAnnuale.setVisible(true);
        });

        buttonConfermaAnnuale.addActionListener(e -> {

            if (!budget.controlloNumero(textModificaAnnuale)) {
                JOptionPane.showMessageDialog(frameModificaAnnuale, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textModificaAnnuale.getText().equals("")) {
                JOptionPane.showMessageDialog(frameModificaAnnuale, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textModificaAnnuale.getText());
                budget.setMaxAnn(nuovoMax);
                aggiornaPannelloAnnuale();
                frameModificaAnnuale.dispose();
            }

            // Reset del JTextField
            textModificaAnnuale.setBackground(Color.decode("#D3D3D3"));
            textModificaAnnuale.setForeground(Color.GRAY);
            textModificaAnnuale.setText(placeholder);

            textModificaAnnuale.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textModificaAnnuale.getText().equals(placeholder)) {
                        textModificaAnnuale.setText("");
                        textModificaAnnuale.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textModificaAnnuale.getText().isEmpty()) {
                        textModificaAnnuale.setForeground(Color.GRAY);
                        textModificaAnnuale.setText(placeholder);
                    }
                }
            });
        });

        JPanel panelTextModificaAnnuale = new JPanel();
        textModificaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTextModificaAnnuale.add(textModificaAnnuale);

        JLabel labelModificaAnnualeTmp = new JLabel("");
        JPanel panelVuotoModificaAnnualeTmp = new JPanel();
        labelModificaAnnualeTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoModificaAnnualeTmp.add(labelModificaAnnualeTmp);

        JPanel panelButtonModificaAnnualeTmp = new JPanel();
        buttonConfermaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonModificaAnnualeTmp.add(buttonConfermaAnnuale);

        panelModificaAnnuale.setLayout(new GridLayout(3, 1));
        panelModificaAnnuale.add(panelTextModificaAnnuale);
        panelModificaAnnuale.add(panelVuotoModificaAnnualeTmp);
        panelModificaAnnuale.add(panelButtonModificaAnnualeTmp);

        frameModificaAnnuale.add(panelModificaAnnuale);

        buttonModificaAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            centraFrame(frameModificaAnnuale);
            frameModificaAnnuale.setVisible(true);
        });

        buttonSiAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            budget.setMaxAnn(-1);
            aggiornaPannelloAnnuale();
            frameEliminaAnnuale.dispose();
        });

        buttonNoAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            frameEliminaAnnuale.dispose();
        });

        JPanel panelTmpEliminaAnnuale = new JPanel();
        buttonSiAnnuale.setPreferredSize(new Dimension(200, 40));
        buttonNoAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTmpEliminaAnnuale.setLayout(new GridLayout(2, 1));
        panelTmpEliminaAnnuale.add(buttonSiAnnuale);
        panelTmpEliminaAnnuale.add(buttonNoAnnuale);

        JLabel labelEliminaAnnualeTmp = new JLabel("<html>Sei sicuro di voler<br>eliminare questo budget?</html>");
        labelEliminaAnnualeTmp.setHorizontalAlignment(SwingConstants.CENTER);

        panelEliminaAnnuale.setLayout(new GridLayout(2, 1));
        panelEliminaAnnuale.add(labelEliminaAnnualeTmp);
        panelEliminaAnnuale.add(panelTmpEliminaAnnuale);

        frameEliminaAnnuale.add(panelEliminaAnnuale);

        buttonEliminaAnnuale.addActionListener(e -> {
            centraFrame(frameEliminaAnnuale);
            frameEliminaAnnuale.setVisible(true);
            frameImpostazioniAnnuale.dispose();
        });

        JPanel panelButtonImpostazioniAnnualeTmp = new JPanel();
        panelButtonImpostazioniAnnualeTmp.setLayout(new GridLayout(2, 1, 0, 10));
        buttonModificaAnnuale.setPreferredSize(new Dimension(200, 40));
        buttonEliminaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonImpostazioniAnnualeTmp.add(buttonModificaAnnuale);
        panelButtonImpostazioniAnnualeTmp.add(buttonEliminaAnnuale);

        panelImpostazioniAnnuale.add(panelButtonImpostazioniAnnualeTmp);
        frameImpostazioniAnnuale.add(panelImpostazioniAnnuale);

        buttonImpostazioniAnnuale.addActionListener(e -> {
            centraFrame(frameImpostazioniAnnuale);
            frameImpostazioniAnnuale.setVisible(true);
        });

        panelCen.addTab("Budget annuale", panelAnnuale);

        // Fino pannello annuale
