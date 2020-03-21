$(function(){
    $("#news1").hover(
        function(){
            $(".box0").css({"z-index" : 1}),
            $(".box1").css({"z-index" : 0}),
            $(".box2").css({"z-index" : 0}),
            $(".box3").css({"z-index" : 0}),
            $(".box4").css({"z-index" : 0}),
            $(".box5").css({"z-index" : 0});
        }
    );

    $("#news2").hover(
        function(){
            $(".box0").css({"z-index" : 0}),
            $(".box1").css({"z-index" : 1}),
            $(".box2").css({"z-index" : 0}),
            $(".box3").css({"z-index" : 0}),
            $(".box4").css({"z-index" : 0}),
            $(".box5").css({"z-index" : 0});
        }
    );

    $("#news3").hover(
        function(){
            $(".box0").css({"z-index" : 0}),
            $(".box1").css({"z-index" : 0}),
            $(".box2").css({"z-index" : 1}),
            $(".box3").css({"z-index" : 0}),
            $(".box4").css({"z-index" : 0}),
            $(".box5").css({"z-index" : 0});
        }
    );

    $("#news4").hover(
        function(){
            $(".box0").css({"z-index" : 0}),
            $(".box1").css({"z-index" : 0}),
            $(".box2").css({"z-index" : 0}),
            $(".box3").css({"z-index" : 1}),
            $(".box4").css({"z-index" : 0}),
            $(".box5").css({"z-index" : 0});
        }
    );

    $("#news5").hover(
        function(){
            $(".box0").css({"z-index" : 0}),
            $(".box1").css({"z-index" : 0}),
            $(".box2").css({"z-index" : 0}),
            $(".box3").css({"z-index" : 0}),
            $(".box4").css({"z-index" : 1}),
            $(".box5").css({"z-index" : 0});
        }
    );

    $("#news6").hover(
        function(){
            $(".box0").css({"z-index" : 0}),
            $(".box1").css({"z-index" : 0}),
            $(".box2").css({"z-index" : 0}),
            $(".box3").css({"z-index" : 0}),
            $(".box4").css({"z-index" : 0}),
            $(".box5").css({"z-index" : 1});
        }
    );
});