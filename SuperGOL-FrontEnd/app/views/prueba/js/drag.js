$( init );
 
function init() {
 
  $('#cardPile').html( '' );
  $('#cardSlots').html( '' );
 
  // Create the pile of shuffled cards
  var numbers = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
  //numbers.sort( function() { return Math.random() - .5 } );
 
  for ( var i=0; i<10; i++ ) 
  {
    if(i == 0 || i == 1)
    {
      $('<div>' + numbers[i] + '</div>').data( 'number', numbers[i] ).data( 'pos', 'Arquero' ).attr( 'id', 'card'+numbers[i] ).appendTo( '#cardPile' ).draggable( {
          containment: '#content',
          stack: '#cardPile div',
          cursor: 'move',
          revert: true        
        } );
    }
    else
    {
      $('<div>' + numbers[i] + '</div>').data( 'number', numbers[i] ).attr( 'id', 'card'+numbers[i] ).appendTo( '#cardPile' ).draggable( {
          containment: '#content',
          stack: '#cardPile div',
          cursor: 'move',
          revert: true
        } );
    }
  }
 
  // Create the card slots
  var words = [ 'Arquero', 'Arquero', 'Def', 'Def', 'Mid', 'Mid', 'Mid', 'Del', 'Del', 'Del' ];
  for ( var i=1; i<=10; i++ ) {
      $('<div>' + words[i-1] + '</div>').data( 'number', i ).data('pos', words[i-1]).appendTo( '#cardSlots' ).droppable( {
        accept: '#cardPile div',
        hoverClass: 'hovered',
        drop: handleCardDrop
       } );
  }
 
}

function handleCardDrop( event, ui ) {
  var slotNumber = $(this).data( 'pos' );
  var cardNumber = ui.draggable.data( 'pos' );
 

 var quienEsta = $(this).data( 'idS');

if(quienEsta != null)
{
  $('#' + quienEsta).removeClass('correct ui-draggable-disabled ui-state-disabled');
  $('#' + quienEsta).removeAttr('aria-disabled');
  $('#' + quienEsta).css("top", "");
  $('#' + quienEsta).css("left", "");
  $('#' + quienEsta).draggable( {
          disabled: false,
          containment: '#content',
          stack: '#cardPile div',
          cursor: 'move',
          revert: true
        } );
}



  $(this).data( 'idS' , $(ui.draggable).attr('id'));
  

  if ( slotNumber == cardNumber ) {
    ui.draggable.addClass( 'correct' );
    ui.draggable.draggable( 'disable' );
    //$(this).droppable( 'disable' );
    ui.draggable.position( { of: $(this), my: 'left top', at: 'left top' } );
    ui.draggable.draggable( 'option', 'revert', false );
  }
}


 