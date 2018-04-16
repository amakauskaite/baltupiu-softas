# baltupiu-softas
## Paskirtis
Šioje repositorijoje laikomi programiniai failai ir dokumentacija, susiję su 2018m pavasario semestrą vykdytu grupiniu darbu, skirtu dalykui "Programų sistemų kūrimas". Toliau pateikiamos diegimo instrukcijos ir reikalingos technologijos, norint pasileisti projektą. Dokumentacija, susijusi su projekto kūrimo ypatumai randama Wiki skiltyje.
## Naudojamos technologijos
- JavaEE
- Maven
  - http://maven.apache.org/guides/
- TomEE
  - http://tomee.apache.org/docs.html
- Hibernate
  - http://hibernate.org/orm/documentation/5.2/
  - http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
- H2
  - http://www.h2database.com/html/main.html
- Junit
  - https://junit.org/junit4/
- Git
  - https://git-scm.com/
- Modern Java IDE
  - IntelliJ (recomenduojama)
  - Eclipse
  - NetBeans
## Projekto paleidimo instrukcija
0. Įsirašyti
   - JDK
     - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   - IDE
   - TomEE
     - http://tomee.apache.org/download-ng.html
     - TomEE plume
   - Git (jei per IDE, nereikia)
1. Clone baltupiu-softas iš github
   - IntelliJ
     - Check out from version control
     - GitHub, Pirmą kart prisijungti
     - Pasirinkti repozitoriją ir jos išsaugojimo vietą
   - Git GUI
     - Clone Existing Repository
     - Source Location: `https://github.com/amakauskaite/baltupiu-softas.git`
     - Target Directory: `path_to_directory/baltupiu-softas`
   - Git
     - `cd path_to_directory`
     - `git clone https://github.com/amakauskaite/baltupiu-softas.git`
2. Import project to IDE
   - IntelliJ
     - Import project, Pasirinkti baltupiu-softas direktoriją
     - Import project from external sources, Maven
     - Žymėti `Search for projects recursively`
     - Next, Next
     - Pasirinkti jdk1.8, `C:\Program Files\Java\jdk1.8.*`
3. Build
   - IntelliJ
     - Run > Edit Configurations... > + > Maven
     - Pasirinkti working directory, command line: `clean install`
4. Paleisti projektą
   - IntelliJ
     - Run > Edit Configurations... > + > TomEE Server > Local
     - Aplication server turi būti TomEE serverio pasirinkimas
     - Deployment tab > + > Artifact... > project-app:war exploded
5. Patikrinti DB
	- Paleidus projektą turėtų automatiškai būti sukurta duomenų bazė
		- Prie duombazių skilties '+' > Data Source > H2
		- User: 'sa'
		- Password: 'sa'
		- URL: 'jdbc:h2:~/h2database/e-shop-db;AUTO_SERVER=TRUE;'
	- Jei sukurta sėkmingai, turėtų pasirodyti sukurtos lentelės. Priešingu atveju siūloma patikrinti konfigūraciją arba perleisti iš naujo projektą.

