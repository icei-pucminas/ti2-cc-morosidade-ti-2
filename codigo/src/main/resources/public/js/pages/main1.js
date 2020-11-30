//#region Tables Keys




$(document).ready(function () {

    //#region Setting Controllers

    //userController = new UserController(userTable, userSessionKey);

    //#endregion

    // //Verify if the current page is not the login page or the cadastro page
    // if (!window.location.pathname.endsWith("index.html") && !window.location.pathname.endsWith("cadastro.html")) {

    //     if (userController.isLoggedIn()) {
	
             userLoggedEnvironment();
	
    //     } else {
    //         window.location.href = "index.html";
    //     }
    // }
    // else {
    //     userController.logout();
    //     $(document).trigger("setDevDataBase");
    //     $(document).trigger("userNotLogged");
    // }
});

function userLoggedEnvironment() {

    $("#pageHeader > .menu-toggle").click(function () {
        if($("#menu").css("display")=="none")
        {
         $("#mainContent").animate({marginLeft: '136'});
         } else $("#mainContent").animate({marginLeft: '0'});
        $('#menu').animate({ width: 'toggle' });
    });
    var a=JSON.parse(sessionStorage.getItem('TbUser'));
    $("#profileName").text(a.nome);

    $(document).trigger("userLogged");
}