$(document).ready(function () {

    //Filtrar Animales
    $('.category_item').click(function () {

        var catProduct = $(this).attr('category');
        console.log(catProduct);

        //Ocultar animales
        $('.product-item').css('transform', 'scale(0)');
        function hideAnimal(){
            $('.product-item').hide();
        } setTimeout(hideAnimal, 400);
       

        //Mostrar los Animales
        function showAnimal(){
            $('.product-item[category="'+catProduct+'"]').show();
            $('.product-item[category="'+catProduct+'"]').css('transform', 'scale(1)');
            
        } setTimeout(showAnimal,400);
       


    });
        //Mostrar todos los animales
       
    $('.category_item[category="todos"]').click(function(){
        function showAll(){
            $('.product-item').show();
            $('.product-item').css('transform', 'scale(1)');
            
        } setTimeout(showAll,400)
    });


});