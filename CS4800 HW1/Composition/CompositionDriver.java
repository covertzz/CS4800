package Composition;
class Driver {
    public static void main(String[] args) {
        Folder php_demo1 = new Folder("php_demo1");
        Folder sourceFiles = new Folder("Source Files");
        Folder phalcon = new Folder(".phalcon");
        Folder app = new Folder("app");
        Folder config = new Folder("config");
        Folder controllers = new Folder("controllers");
        Folder library = new Folder("library");
        Folder migrations = new Folder("migrations");
        Folder models = new Folder("models");
        Folder views = new Folder("views");
        Folder cache = new Folder("cache");
        Folder publiC = new Folder("public");
        Folder includePath = new Folder("Include Path");
        Folder remoteFiles = new Folder("Remote Files");

        File htaccess = new File(".htaccess");
        File htrouterPhp = new File(".htrouter.php");
        File indexhtml = new File("index.html");


        php_demo1.addItem(sourceFiles);
        sourceFiles.addItem(phalcon);
        sourceFiles.addItem(app);
        app.addItem(config);
        app.addItem(controllers);
        app.addItem(library);
        app.addItem(migrations);
        app.addItem(models);
        app.addItem(views);
        sourceFiles.addItem(cache);
        sourceFiles.addItem(publiC);
        publiC.addItem(htaccess);
        publiC.addItem(htrouterPhp);
        publiC.addItem(indexhtml);
        sourceFiles.addItem(includePath);
        sourceFiles.addItem(remoteFiles);

        php_demo1.print();
        
        //For question 2:
        /*php_demo1.delete(app);
        php_demo1.print(0);*/

        //For question 3:
        /*php_demo1.delete(publiC);
        php_demo1.print();*/

    }   
}