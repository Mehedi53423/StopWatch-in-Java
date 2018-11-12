public class Sw01 extends javax.swing.JFrame {

    static int miliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;

    static boolean state = true;

    public Sw01() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        minute = new javax.swing.JLabel();
        second = new javax.swing.JLabel();
        milisecond = new javax.swing.JLabel();
        hour = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StopWatch");

        minute.setFont(new java.awt.Font("Times New Roman", 0, 48));
        minute.setText("00 :");

        second.setFont(new java.awt.Font("Times New Roman", 0, 48));
        second.setText("00 :");

        milisecond.setFont(new java.awt.Font("Times New Roman", 0, 36));
        milisecond.setText("00");

        hour.setFont(new java.awt.Font("Times New Roman", 0, 48));
        hour.setText("00 :");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jButton1.setText("Stop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jButton5.setText("Start");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(hour, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(minute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(second)
                        .addGap(10, 10, 10)
                        .addComponent(milisecond))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour)
                    .addComponent(minute)
                    .addComponent(second)
                    .addComponent(milisecond))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

        state = true;

        Thread t = new Thread(){
            public void run(){
                for(;;){
                    if(state == true){
                        try{
                            sleep(1);

                            if(miliseconds > 1000){
                                miliseconds = 0;
                                seconds++;
                            }

                            if(seconds > 60){
                                miliseconds = 0;
                                seconds = 0;
                                minutes++;
                            }

                            if(minutes > 60){
                                miliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                            }

                            milisecond.setText(" : "+miliseconds);
                            miliseconds++;
                            second.setText(" : "+seconds);
                            minute.setText(" : "+minutes);
                            hour.setText(""+hours);

                        }
                        catch(Exception e){

                        }
                    }
                    else{
                        break;
                    }
                }
            }
        };
        t.start();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        state = false;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

        state = false;

        hours = 0;
        minutes = 0;
        seconds = 0;
        miliseconds = 0;

        hour.setText("00 :");
        minute.setText("00 :");
        second.setText("00 :");
        milisecond.setText("00");
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sw01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sw01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sw01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sw01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sw01().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel hour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel milisecond;
    private javax.swing.JLabel minute;
    private javax.swing.JLabel second;
}
