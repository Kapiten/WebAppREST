/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function test() {
    var pg = window.open("");
    pg.document.write("<html><head><title>New Page</title></head><body>Test the new page.</body></html>");
}

/*function showservicepage() {
    var pg = window.open("");
    pg.document.write("<html>\n\
<head><title>New Page</title></head>\n\
<body>Test the new page here.\n\
</body>\n\
</html>");
}*/

function showservicepage(page) {
    var pg = window.open("");
    pg.document.write("<html>\n\
<head><title>New Page</title></head>\n\
<body>\n\
<h1>"+page+" Service contents<h1>\n\
<p>Server response <a href='/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+page.toString().replace(" ","").toLowerCase()+"'>here...</a></p>\n\
<iframe src='/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+page.toString().replace(" ","").toLowerCase()+"'></iframe>\n\
</body>\n\
</html>");
}
