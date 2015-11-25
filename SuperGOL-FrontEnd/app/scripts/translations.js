function translations($translateProvider) {
  $translateProvider
    .translations('en', {
      HEADLINE: 'SuperGol',
      INTRO_TEXT: 'And it has i18n support!',
      BUTTON_TEXT_EN: 'english',
      BUTTON_TEXT_ES: 'spanish',
      H1_TEAM: 'Create your team',
      H1_LEAGUE: 'Leagues',
      H1_REGISTER: 'Register',
      R_FIELDS: 'Requiered Fields',
      R_USER: 'User Name',
      R_BUTTON: 'Sign Up',
      H1_PLAYER: 'Players',
      LEAGUE_N : 'Name',
      LEAGUE_E : 'Edit',
      LEAGUE_B : 'Create League',
      TEAM_A : 'GOALKEEPER',
      TEAM_DEF: 'DFENDER',
      TEAM_MED: 'MIDFIELD',
      TEAM_DEL: 'FORWARD',
      TEAM_B: 'Create',
      TEAM_NAME: 'Name of the Team',
      MENU_TEAM: 'Create Team',
      MENU_PLAYER: 'Create Player',
      INICIAR_S: 'Sign In',
      USER: 'User',
      LAST_NAME: 'Last Name',
      TEAM: 'Team',
      POSITION: 'Position',
      DELETE: 'Delete',
      SAVE: 'Save',
      CANCEL: 'Cancel',
      UPDATE: 'Update Date',
      JOIN: 'Join'
      

    })
    .translations('es', {
      HEADLINE: 'SuperGol',
      INTRO_TEXT: 'La plataforma recompensa a los jugadores en funcion a los conocimientos y palpitos deportivos.Cada usuario es un seleccionador de jugadores que conforman un equipo de fantasía que participa en  contra otros participantes.El desempeño de cada equipo estara determinado por el desempeño de los jugadores elegidos en una modalidad de todos contra todos',
      BUTTON_TEXT_EN: 'ingles',
      BUTTON_TEXT_DE: 'español',
      H1_TEAM: 'Crea tu equipo',
      H1_LEAGUE: 'Ligas',
      H1_REGISTER: 'Registrate',
      R_FIELDS: 'Campos Requeridos',
      R_USER: 'Nombre de Usuario',
      R_BUTTON: 'Registrate',
      H1_PLAYER: 'Jugadores',
      LEAGUE_N: 'Nombre',
      LEAGUE_E: 'Editar',
      LEAGUE_B: 'Crear Liga',
      TEAM_A: 'ARQUERO',
      TEAM_DEF: 'DEFENSOR',
      TEAM_MED: 'VOLANTE',
      TEAM_DEL: 'DELANTERO',
      TEAM_B: 'Crear',
      TEAM_NAME: 'Nombre del Equipo',
      MENU_TEAM: 'Crear Equipo',
      MENU_PLAYER: 'Crear Jugador',
      INICIAR_S: 'Iniciar Sesion',
      USER: 'Usuario',
      LAST_NAME: 'Apellido',
      TEAM: 'Equipo',
      POSITION: 'Posicion',
      DELETE: 'Eliminar',
      SAVE: 'Guardar',
      CANCEL: 'Cancelar',
      UPDATE: 'Actualizar Fecha',
      JOIN: 'Unirse'
    
    });

  $translateProvider.preferredLanguage('es');
  $translateProvider.useSanitizeValueStrategy('sanitize');
}