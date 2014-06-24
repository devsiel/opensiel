package opensiel.beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class kitmin {
	private String nombase;
    public void setbasenom( String nom ) {
        this.nombase = nom;
    }

    public String getbasenom() {
        return nombase;
    }

    public void creerbase( String nom ) throws SQLException {
    	Connection conn=null;
    	
    	try{
	    	  Class.forName("org.postgresql.Driver");   
    	      String url = "jdbc:postgresql://localhost:5432/postgres";
    	      String user = "postgres";
    	      String passwd = "postgres";  
    	      conn = DriverManager.getConnection(url, user, passwd);
    	      Statement stmt = (Statement) conn.createStatement();
    	      ResultSet rs = stmt.executeQuery("CREATE DATABASE "+nom+" WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default ;");
    	      System.out.println("Création de la base :"+nom+", terminée");
    		  stmt=null;
    		  rs=null;
    		  conn.close();
    	}
	       catch (Exception base){
			   base.printStackTrace(); 
		     }
    }
    public void creerkitmin( String nom ) throws SQLException {
    	Connection conn=null;
    	
    	try{
	    	  Class.forName("org.postgresql.Driver");   
    		  String url = "jdbc:postgresql://localhost:5432/"+nom;
    		  String user = "postgres";
    	      String passwd = "postgres";
    		  conn = DriverManager.getConnection(url, user, passwd);
    	      Statement stmt = (Statement) conn.createStatement();
    	      String req="";
    	      req= req+ "CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;";
    	      req= req+ "CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;";
    	      req= req+ "CREATE TABLE aptitudesol ( codeaptitude integer NOT NULL, descaptitude character varying(100), codeobservatoire character varying(50) DEFAULT ''::character varying);";
    	      req= req+ "CREATE TABLE aptitudesolpratique (codeaptitude integer NOT NULL,idpratcomb smallint NOT NULL,productagri double precision,productfore double precision);";
    	      req= req+ "CREATE TABLE capratique (caid character varying(100) NOT NULL,idpratcomb integer NOT NULL);";
    	      req= req+ "CREATE TABLE centreactivite (caid character varying(100) NOT NULL,codeobservatoire character varying(50) DEFAULT ''::character varying,nomcentre character varying(100),agemin integer,agemax integer,typecentdecis character varying(100),typesysproduct character varying(100),dseuil integer,superficie real DEFAULT 0);";
    	      req= req+ "CREATE TABLE constglobaleappli (n° integer NOT NULL,nommodelisation character varying(50) NOT NULL,observcourant character varying(50) NOT NULL,codeobservcourant character varying(50),periodecourantedeb timestamp without time zone NOT NULL,periodecourantefin timestamp without time zone NOT NULL,datemodif timestamp without time zone NOT NULL,actstruct character varying(50) NOT NULL,modelcourant smallint NOT NULL,lang character varying(3),versionbasesiel character varying(50) DEFAULT '1.4-c'::character varying);";
    	      req= req+ "CREATE TABLE cteobservatoire (codeobservatoire character varying(50) DEFAULT ''::character varying NOT NULL,cteprefboiszhec double precision,cteconsocultu double precision,ctesemence double precision,ctesurfsem double precision,cteconsofour double precision,cteconsobois double precision,cteconsoani double precision,ctecommerceagri double precision,ctecommercepast double precision,ctecommercefore double precision,ctestockpast double precision,ctestockfore double precision,actstruct character varying(50));";
    	      req= req+ "CREATE TABLE groupeagents (gaid character varying(100) NOT NULL,caid character varying(100),nomgroupe character varying(100),precisionpop character varying(1),anneepop smallint,typeagent character varying(50),idgroupstrat character varying(50));";
    	      req= req+ "CREATE TABLE groupstratpratique (idpratcomb smallint NOT NULL,idgroupstrat character varying(100) NOT NULL);";
    	      req= req+ "CREATE TABLE parametrepratiquecombinee (idpratcomb smallint NOT NULL,nomcalcul character varying(50) NOT NULL,nommethode character varying(50) NOT NULL,nomparam character varying(100) NOT NULL,valparam double precision);";
    	      req= req+ "CREATE TABLE parametresaison (nomparam character varying(100) NOT NULL,saison character varying(100) NOT NULL,caid character varying(100) NOT NULL,valparam double precision,gaid character varying(50) NOT NULL);";
    	      req= req+ "CREATE TABLE pctbonmoymau (nomproduction character varying(50) NOT NULL,codeobservatoire character varying(50) DEFAULT ''::character varying NOT NULL,bon integer,moy integer,mau integer);";
    	      req= req+ "CREATE TABLE pctdispobiomasse (codeobservatoire character varying(50) DEFAULT ''::character varying NOT NULL,catoccup character varying(50) NOT NULL,usage character varying(50) NOT NULL,mstotal integer,msherba integer,mslignb integer,mslignh integer);";
    	      req= req+ "CREATE TABLE pratiquecombinee (idpratcomb smallint NOT NULL,codeobservatoire character varying(50) DEFAULT ''::character varying,descpratcomb character varying(100));";
    	      req= req+ "CREATE TABLE tablang (idlib character varying(200) NOT NULL,lang character varying(5) NOT NULL,vallib character varying(255));";
    	      req= req+ "CREATE TABLE tablangdb (idlib character varying(69),lang character varying(9),vallib character varying(120));";
    	      req= req+ "CREATE TABLE tablistecode (nomliste character varying(50) NOT NULL,nomliste2 character varying(50),valeur character varying(50) NOT NULL,descvaleur character varying(200),caracnumsuppl character varying(50),valeurcarac integer);";
    	      req= req+ "CREATE TABLE territoireobservatoire (codeobservatoire character varying(6) NOT NULL,nummodelisation integer NOT NULL,datemodel timestamp without time zone,datedebvalcte timestamp without time zone,datefinvalcte timestamp without time zone,p_produpc text,exedentupc double precision,nb_exedentupc integer,deficitupc double precision,nb_deficitupc integer,p_delim character varying(250),tx_validdelim double precision,nb_polytest integer,modelterri character varying(10),typeterri character varying(10),typecentac character varying(150),po_resdelim integer,p_upcbesoin character varying(50),p_ptabdupc character varying(50),po_resupc integer,p_interup character varying(50),p_mbilanusr character varying(255),tx_validdelim_upc double precision,nb_polytest_upc smallint,pdelim_gr character varying(200),pbesoin_gr character varying(200),pbilan_veg character varying(200));";
    	      req= req+ "CREATE TABLE typecalcul (idpratcomb smallint NOT NULL,nomcalcul character varying(50) NOT NULL,nommethode character varying(50) NOT NULL);";
    	      req= req+ "CREATE TABLE typeoccupationsol (nomoccup character varying(100) NOT NULL,idpratcomb smallint NOT NULL,pourcent double precision);";
    	      req= req+ "CREATE TABLE unitpaysagoccupation (saison character varying(50) NOT NULL,codeup integer NOT NULL,nomoccup character varying(100) NOT NULL,codeobservatoire character varying(50),msherba double precision,mslignb double precision,mslignh double precision,mstotal double precision);";
    	      req= req+ "CREATE TABLE unitpaysagprelpref (saison character varying(50) NOT NULL,codeup integer NOT NULL,codeobservatoire character varying(50) DEFAULT ''::character varying NOT NULL,prefprelveg_past double precision DEFAULT 1 NOT NULL,prefprelveg_fore double precision DEFAULT 1 NOT NULL,prefprelveg_agri double precision DEFAULT 1 NOT NULL);";
    	      req= req+ "CREATE TABLE up (codeup integer NOT NULL,nomunit character varying(100),codeobservatoire character varying(50) DEFAULT ''::character varying);";
  			 
    	      req= req+ "alter table  cteobservatoire add constraint pk_cteobservatoire primary key (codeobservatoire);";    
    	      req= req +"alter table  territoireobservatoire add constraint pk_territoireobservatoire primary key (codeobservatoire,nummodelisation);";
  			  req= req +"alter table  territoireobservatoire add constraint fk_terriobs_cteobs foreign key (codeobservatoire) references cteobservatoire(codeobservatoire);";
  			  
  			  req= req +"alter table  centreactivite add constraint pk_centreactivite primary key(caid);";
      		  req= req +"alter table  centreactivite add  constraint fk_cat_cteobs foreign key (codeobservatoire) references cteobservatoire(codeobservatoire);";
      		  
      		  req= req +"alter table groupeagents add constraint pk_groupeagents primary key (gaid);";
              req= req +"alter table groupeagents add constraint fk_gi_cat  foreign key (caid) references centreactivite(caid);";
              
              req= req +"alter table parametresaison add constraint pk_param primary key (nomparam,saison,caid,gaid);";
              req= req +"alter table parametresaison add constraint fk_par_ca  foreign key (caid) references centreactivite(caid);";
              req= req +"alter table parametresaison add constraint fk_par_ga  foreign key (gaid) references groupeagents(gaid);";
              
              req= req +"alter table  pratiquecombinee add constraint pk_prat primary key (idpratcomb);";
              req= req +"alter table  pratiquecombinee add constraint fk_prat_cteobs foreign key (codeobservatoire) references cteobservatoire(codeobservatoire);";
              
  			  req= req +"alter table  capratique add constraint capratique_primarykey primary key (caid, idpratcomb);";
  			  req= req +"alter table  capratique add constraint centreactivitecapratique_caid_centreactivite_caid foreign key (caid) references centreactivite(caid);";
  			  
  			  req= req +"alter table  capratique add constraint pratiquecombineecapratique_idpratcomb_pratiquecombinee_idpratco foreign key (idpratcomb) references pratiquecombinee(idpratcomb);";
  			
  			  req= req +"alter table  typecalcul add constraint pk_typecalcul primary key (idpratcomb, nomcalcul, nommethode);";
  			  req= req +"alter table  typecalcul add constraint fk_typec_prat foreign key (idpratcomb) references pratiquecombinee(idpratcomb);";
              
  			  req= req +"alter table  parametrepratiquecombinee add constraint pk_parametrepratiquecombinee primary key (nomparam,idpratcomb, nomcalcul, nommethode);";
              req= req +"alter table  parametrepratiquecombinee add constraint fk_paraprat_typec foreign key (idpratcomb, nomcalcul, nommethode) references typecalcul(idpratcomb,nomcalcul,nommethode);";
              
              req= req +"alter table  typeoccupationsol add constraint pk_typeoccupationsol primary key (nomoccup, idpratcomb);";
  			  req= req +"alter table  typeoccupationsol add constraint fk_typeo_prat  foreign key (idpratcomb) references pratiquecombinee(idpratcomb);";
  			
  			  req= req +"alter table  aptitudesol add constraint pk_aptitudesol  primary key(codeaptitude);";
              req= req +"alter table  aptitudesol add constraint fk_sol_cteobs foreign key (codeobservatoire) references cteobservatoire(codeobservatoire);";
              
              req= req +"alter table  aptitudesolpratique add constraint pk_aptitudesolpratique primary key(codeaptitude,idpratcomb);";
              req= req +"alter table  aptitudesolpratique add constraint fk_aptsol_sol  foreign key (codeaptitude) references aptitudesol(codeaptitude);";
              req= req +"alter table  aptitudesolpratique add constraint fk_aptsol_prat  foreign key (idpratcomb) references pratiquecombinee(idpratcomb);";
              
              req= req +"alter table  up add constraint pk_up primary key(codeup);";
              req= req +"alter table  up add constraint fk_up_cteobs foreign key (codeobservatoire) references cteobservatoire(codeobservatoire);";
              
              req= req +"alter table  unitpaysagoccupation add constraint pk_unitpaysagoccupation primary key(nomoccup, codeup, saison);";
              req= req +"alter table  unitpaysagoccupation add constraint fk_upoccup_cteobs foreign key (codeobservatoire) references  cteobservatoire(codeobservatoire);";
  			  req= req +"alter table  unitpaysagoccupation add constraint fk_upoccup_up foreign key (codeup) references up(codeup);";
              
  			  req= req +"alter table  pctbonmoymau add constraint pk_pctbmm primary key(nomproduction,codeobservatoire);";
              req= req +"alter table  pctbonmoymau add constraint fk_pct_cteobs foreign key (codeobservatoire) references  cteobservatoire(codeobservatoire);";
             
              req= req +"alter table  pctdispobiomasse add constraint pk_pctdispobio primary key(catoccup,usage);";
    	      ResultSet rs = stmt.executeQuery(req);
    	      conn.close();
    	      stmt.close();
    	      rs.close();
    	      System.out.println("Création de kitmin pour la la base :"+nom+", terminée");
    	}
	       catch (Exception base){
			   base.printStackTrace(); 
		     }
    }
}
