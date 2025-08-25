//package kap7;

/*
// butikk.sql
// -> sqlite3 butikk.db
// -> read butikk.sql

create table Vare
(
    Nr      integer primary key,
    Navn    varchar(50),
    Pris    decimal(8,2),
    Antall  integer
);

insert into Vare values(1, 'Spade', 220.50, 23);
insert into Vare values(2, 'Hakke', 199.00, 17);
insert into Vare values(3, 'Spett', 170.00, 58);
*/

/*
public class VareSok {
    
    public static void main(String[] args) {
        //visVarer();
    }

    private static void visVarer(double prisGrense) throws Exception {
        String url = "jdbc:sqlite:butikk.db";
        String sql = "select * from Vare where Pris < " + prisGrense;
        Connection con DriverManager.getConnection(url);
        Statement stmt = con.CreateStatement();
        ResultSet rs = stmt.executeQuery(sql);
        DecimalFormat df = new DecimalFormat("#.00");
        int vareNr;
        String varenavn
        double pris;
        int antall;
        while (rs.next()) {
            vareNr = rs.getInt("Nr");
            varenavn = rs.GetString("Navn");
            pris = rs.getDouble("Pris");
            antall = rs.getInt("Antall");

            out.println("Nr: " + vareNr
                + ", Navn: " + varenavn
                + ", Pris: " + df.format(pris)
                + ", Antall: " + antall);
        }
        con.close();
    }

}
*/
