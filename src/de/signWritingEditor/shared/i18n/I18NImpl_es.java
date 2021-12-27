package de.signWritingEditor.shared.i18n;

import org.apache.xpath.operations.String;

public class I18NImpl_es implements I18N {

	public I18NImpl_es() {
	}

	@Override
	public I18NLocale getLocale() {
		return I18NLocale.ES;
	}

	@Override
	public String getLocaleName() {
		return "ES";
	}

	@Override
	public String getRoomPolicyCollectiveLongDescription() {
		return "Todos los documentos se pueden usar libremente";
	}

	@Override
	public String getAllUsers() {
		return "Todos los usuarios";
	}

	@Override
	public String getCancel() {
		return "Cancelar";
	}

	@Override
	public String getCantMoveFolderIntoItself() {
		return "No se puede mover una carpeta dentro de sí misma";
	}

	@Override
	public String getRoomPolicySharedLongDescription() {
		return "No está permitido cambiar o eliminar documentos ajenos";
	}

	@Override
	public String getCheckUserNameAndPassword() {
		return "Compruebe el nombre de usuario y la contraseña.";
	}

	@Override
	public String getClose() {
		return "Cerrar";
	}

	@Override
	public String getDoCreatePdf() {
		return "Crear PDF";
	}

	@Override
	public String getCreatingPdf() {
		return "Creando PDF…";
	}

	@Override
	public String getCreationDate() {
		return "Fecha de creación";
	}

	@Override
	public String getConfirmDeletionTitle() {
		return "Eliminar";
	}

	@Override
	public String getDoDeleteDocument() {
		return "Eliminar";
	}

	@Override
	public String getConfirmDeleteItem() {
		return "¿Desea eliminar permanentemente el siguiente objeto?";
	}

	@Override
	public String getConfirmDeleteItems() {
		return "¿Desea eliminar permanentemente los siguientes objetos?";
	}

	@Override
	public String getDoYouWantToSaveTheChanges() {
		return "¿Desea guardar los cambios?";
	}

	@Override
	public String getDocumentAlreadyExists() {
		return "El documento ya existe";
	}

	@Override
	public String getDocumentManager() {
		return "Administrador de documentos";
	}

	@Override
	public String getDocumentName() {
		return "Nombre del documento";
	}

	@Override
	public String getDocumentNotSaved() {
		return "No se guardó el documento";
	}

	@Override
	public String getDoChangeTitle() {
		return "Cambiar nombre";
	}

	@Override
	public String getErrorOnCreatingNewFolder() {
		return "Error al crear la nueva carpeta";
	}

	@Override
	public String getErrorOnCreatingPdf() {
		return "Error al crear el documento PDF";
	}

	@Override
	public String getErrorOnDeletingDocument() {
		return "Error al eliminar el documento";
	}

	@Override
	public String getErrorOnDeletingDocuments() {
		return "Error al eliminar los documentos";
	}

	@Override
	public String getErrorOnInitialisingIds() {
		return "Error al inicializar la aplicación";
	}

	@Override
	public String getErrorOnLoadingDocument() {
		return "Error al cargar el documento";
	}

	@Override
	public String getErrorOnLoadingDocumentNames() {
		return "Error al cargar los nombres del documento";
	}

	@Override
	public String getErrorOnLoadingRootFolderItem() {
		return "Error al cargar el directorio raíz";
	}

	@Override
	public String getErrorOnLogin() {
		return "Error al iniciar la sesión";
	}

	@Override
	public String getErrorOnMoveFiles() {
		return "Error al mover los objetos";
	}

	@Override
	public String getErrorOnRenamingFile() {
		return "Error al cambiar el nombre del objeto";
	}

	@Override
	public String getErrorOnSavingDocument() {
		return "Error al guardar el documento";
	}

	@Override
	public String getFileNameAlreadyTaken() {
		return "El nombre del archivo ya existe.<br>Escriba otro nombre.";
	}

	@Override
	public String getFolderName() {
		return "Nombre de carpeta";
	}

	@Override
	public String getFreetextVisibility() {
		return "Línea de texto libre";
	}

	@Override
	public String getHello() {
		return "Hola";
	}

	@Override
	public String getPaperSizeLandscape() {
		return "Horizontal";
	}

	@Override
	public String getSignLocaleDescription() {
		return "Idioma";
	}

	@Override
	public String getLoadingDocument() {
		return "Cargando el documento...";
	}

	@Override
	public String getDoLogin() {
		return "Iniciar sesión";
	}

	@Override
	public String getLoginFailed() {
		return "Error de inicio de sesión";
	}

	@Override
	public String getDoLogout() {
		return "Cerrar sesión";
	}

	@Override
	public String getModificationDate() {
		return "Fecha de modificación";
	}

	@Override
	public String getMoveFile() {
		return "Mover";
	}

	@Override
	public String getConfirmMoveItemToRecycleBin() {
		return "¿Desea mover el siguiente objeto a la papelera de reciclaje?";
	}

	@Override
	public String getConfirmMoveItemsToRecycleBin() {
		return "¿Desea mover los siguientes objetos a la papelera de reciclaje?";
	}

	@Override
	public String getName() {
		return "Nombre";
	}

	@Override
	public String getNewFile() {
		return "Nuevo";
	}

	@Override
	public String getNewDocument() {
		return "Nuevo documento";
	}

	@Override
	public String getNewFileTitle() {
		return "Nombre nuevo";
	}

	@Override
	public String getNewFolder() {
		return "Nueva carpeta";
	}

	@Override
	public String getNo() {
		return "No";
	}

	@Override
	public String getNote() {
		return "Nota";
	}

	@Override
	public String getDoOpenDocument() {
		return "Abrir";
	}

	@Override
	public String getOverwriteQuestion() {
		return "¿Sobrescribir?";
	}

	@Override
	public String getOwner() {
		return "Propietario";
	}

	@Override
	public String getPageFormatDescription() {
		return "Diseño de página";
	}

	@Override
	public String getPassword() {
		return "Contraseña";
	}

	@Override
	public String getPleaseEnterValidFileName() {
		return "Escriba un nombre de archivo válido.";
	}

	@Override
	public String getPleaseWait() {
		return "Espere";
	}

	@Override
	public String getPaperSizePortrait() {
		return "Vertical";
	}

	@Override
	public String getPublicRoomName() {
		return "Playground";// TODO Übersetzen
	}

	@Override
	public String getRecycleBinName() {
		return "Papelera de reciclaje";
	}

	@Override
	public String getRenameFile() {
		return "Cambiar nombre";
	}

	@Override
	public String getResponsible() {
		return "Responsable";
	}

	@Override
	public String getRoomPolicy() {
		return "Reglamento de la sala";
	}

	@Override
	public String getRoomUsers() {
		return "Usuarios de la sala";
	}

	@Override
	public String getSave() {
		return "Guardar";
	}

	@Override
	public String getSaveAs() {
		return "Guardar como";
	}

	@Override
	public String getSearchWordLine() {
		return "Línea de palabra de búsqueda";
	}

	@Override
	public String getTheDocument0CouldNotBeDeleted(Object param0) {
		return "No se pudo eliminar el documento " + param0 + ".";
	}

	@Override
	public String getTheDocuments0CouldNotBeDeleted(Object param0) {
		return "No se pudieron eliminar los documentos " + param0 + ".";
	}

	@Override
	public String getTypeName() {
		return "Tipo";
	}

	@Override
	public String getAccessDeniedOnCreatingNewFolder() {
		return "No está permitido crear la carpeta";
	}

	@Override
	public String getAccessDeniedOnDeletingFiles() {
		return "No está permitido eliminar los archivos";
	}

	@Override
	public String getAccessDeniedOnEnteringRoom() {
		return "No está permitido entrar a la sala";
	}

	@Override
	public String getErrorOnInitialisingDocumentManager() {
		return "Error al inicializar el administrador de documentos";
	}

	@Override
	public String getErrorLoadingSign() {
		return "Error al cargar la seña";
	}

	@Override
	public String getAccessDeniedOnMovingFiles() {
		return "No está permitido mover los archivos";
	}

	@Override
	public String getAccessDeniedOnOpeningDocument() {
		return "No está permitido abrir el documento";
	}

	@Override
	public String getAccessDeniedOnOpeningFolder() {
		return "No está permitido abrir la carpeta";
	}

	@Override
	public String getAccessDeniedOnOverwritingDocument() {
		return "No está permitido sobrescribir el documento";
	}

	@Override
	public String getAccessDeniedOnRenamingFile() {
		return "No está permitido cambiar el nombre al archivo";
	}

	@Override
	public String getErrorOnSyncFilesWithServer() {
		return "Error de coincidencia de archivos con el servidor";
	}

	@Override
	public String getUnknownUserName() {
		return "Desconocido";
	}

	@Override
	public String getUserName() {
		return "Nombre de usuario";
	}

	@Override
	public String getRoomPolicyIndividualLongDescription() {
		return "No está permitido usar documentos ajenos";
	}

	@Override
	public String getVersion() {
		return "Versión";
	}

	@Override
	public String getYes() {
		return "Si";
	}

	@Override
	public String getAccept() {
		// TODO Übersetzen
		return "Accept";
	}

	@Override
	public String getDecline() {
		// TODO Übersetzen
		return "Decline";
	}

	@Override
	public String getDateTimeFormat() {
		return "dd/MM/yyyy - HH:mm";
	}

	@Override
	public String getDateFormat() {
		return "dd/MM/yyyy";
	}

	@Override
	public String getAccessDeniedTitle() {
		return "Acceso denegado";
	}

	@Override
	public String getErrorOnLoadingSigns() {
		return "Error al cargar las señas";
	}

	@Override
	public String getWhenYouLeavePageUnsavedChangesGetLost() {
		return "Si abandona la página, se perderán los cambios no guardados.";
	}

	@Override
	public String getDoDeleteSymbol() {
		return "Eliminar símbolo";
	}

	@Override
	public String getRootFolderName() {
		return "Inicio";
	}

	@Override
	public String getSignWritingLine() {
		return "Línea de escritura de señas";
	}

	@Override
	public String getSignEditor() {
		return "Editor de señas";
	}

	@Override
	public String getErrorLoadingSymbols() {
		return "Error al cargar los símbolos";
	}

	@Override
	public String getAccessDeniedOnCopyingFiles() {
		return "No se pueden copiar los archivos";
	}

	@Override
	public String getAccessDeniedOnDeletingFile() {
		return "El archivo no se puede eliminar";
	}

	@Override
	public String getAccessDeniedOnLoadDocument() {
		return "No se puede cargar el documento";
	}

	@Override
	public String getAccessDeniedOnSaveOrUpdateDocument() {
		return "El documento no se puede guardar ni sobrescribir";
	}

	@Override
	public String getAccountNotActivated() {
		return "La cuenta aún no se ha activado";
	}

	@Override
	public String getAccountValidationSuccessful() {
		return "Cuenta correctamente activada.";
	}

	@Override
	public String getActivateAccount() {
		return "Activar cuenta";
	}

	@Override
	public String getAddAdmin() {
		return "Agregar responsable";
	}

	@Override
	public String getAddHand() {
		return "Agregar manos";
	}

	@Override
	public String getAddHandsSymbol() {
		return "Agregar icono de las manos";
	}

	@Override
	public String getAddHeadSymbol() {
		return "Insertar icono de cabeza";
	}

	@Override
	public String getAddMovementCircleSymbol() {
		return "Agregar icono de movimiento circular";
	}

	@Override
	public String getAddMovementCurvesHitFloorPlaneSymbol() {
		return "Agregar movimiento curvado a través del nivel de escritorio";
	}

	@Override
	public String getAddMovementDiagonalPlaneSymbol() {
		return "Agregar icono de movimiento en el plano diagonal";
	}

	@Override
	public String getAddMovementFloorPlaneSymbol() {
		return "Agregar icono de movimiento en el nivel de escritorio";
	}

	@Override
	public String getAddMovementSymbol() {
		return "Agregar icono de movimiento";
	}

	@Override
	public String getAddMovementWallPlaneSymbol() {
		return "Agregar icono de movimiento en el nivel del salvapantallas";
	}

	@Override
	public String getAddNewElement() {
		return "Agregar elemento";
	}

	@Override
	public String getAddNewPage() {
		return "Agregar nueva página";
	}

	@Override
	public String getAddSignToken() {
		return "Agregar signo";
	}

	@Override
	public String getAddTextbox() {
		return "Agregar cuadro de texto";
	}

	@Override
	public String getAddUser() {
		return "Agregar usuario de la sala";
	}

	@Override
	public String getAdminAddedToRoomSuccessfully() {
		return "Se agregó correctamente un responsable a la sala";
	}

	@Override
	public String getAirRelatedBodySymbols() {
		return "Iconos de respiración flotantes";
	}

	@Override
	public String getArrangeFingerAlphabet() {
		return "Alinear alfabeto manual";
	}

	@Override
	public String getArrangeVisemes() {
		return "Ordenar cabezas";
	}

	@Override
	public String getAuthor() {
		return "Autor";
	}

	@Override
	public String getAutomaticFreeTextLine() {
		return "Línea automática de texto libre";
	}

	@Override
	public String getBadge() {
		return "Medallas";
	}

	@Override
	public String getBadgeStatusForHighestRank() {
		return "Enhorabuena. Has recibido la medalla de mayor valor. Trata de obtener otras medallas.";
	}

	@Override
	public String getChangeColorLabel() {
		return "Modificar etiqueta de color";
	}

	@Override
	public String getChangeComment() {
		return "Comentario sobre la modificación";
	}

	@Override
	public String getChangeFontBackgroundColor() {
		return "Modificar el color de fondo del texto";
	}

	@Override
	public String getChangeFontColor() {
		return "Modificar el color del texto";
	}

	@Override
	public String getChangeFontStyle() {
		return "Modificar fuente";
	}

	@Override
	public String getChangeLayer() {
		return "Modificar nivel de los iconos";
	}

	@Override
	public String getChangeLineVisibility() {
		return "Mostrar y ocultar elementos";
	}

	@Override
	public String getChangePassword() {
		return "Cambiar contraseña";
	}

	@Override
	public String getChangeSignBackground() {
		return "Seleccionar fondo de signos";
	}

	@Override
	public String getChangeSignVartiation() {
		return "Modificar variaciones de signos";
	}

	@Override
	public String getChangeSignwordVisibility() {
		return "Mostrar y ocultar líneas de escritura de signos";
	}

	@Override
	public String getChooseSignBoxBackgroundColor() {
		return "Seleccionar fondo de signos";
	}

	@Override
	public String getChooseTextBoxBackgroundColor() {
		return "Seleccionar fondo de texto";
	}

	@Override
	public String getChooseTextColor() {
		return "Seleccionar color del texto";
	}

	@Override
	public String getColorLabel() {
		return "Etiqueta de color";
	}

	@Override
	public String getComment() {
		return "Comentario";
	}

	@Override
	public String getCongratulationsForReceivingNewBadges() {
		return "Enhorabuena por obtener nuevas medallas.";
	}

	@Override
	public String getContinue() {
		return "Continuar";
	}

	@Override
	public String getCopyDocument() {
		return "Copiar documento";
	}

	@Override
	public String getCopyFile() {
		return "Copiar";
	}

	@Override
	public String getCopySymbol() {
		return "Copiar icono";
	}

	@Override
	public String getCreateNameExample() {
		return "Ejemplo: Crear nombres de signos";
	}

	@Override
	public String getCreateNewDocument() {
		return "Crear documento";
	}

	@Override
	public String getCreateNewFolder() {
		return "Crear nueva carpeta";
	}

	@Override
	public String getCreatedBy() {
		return "Creado por";
	}

	@Override
	public String getDecreaseZIndex() {
		return "Nivel anterior";
	}

	@Override
	public String getDelete() {
		return "Eliminar signo";
	}

	@Override
	public String getDeleteAdmin() {
		return "Eliminar responsable";
	}

	@Override
	public String getDeleteAllVisemes() {
		return "Eliminar todas las cabezas";
	}

	@Override
	public String getDeleteAskForConfirmationMessage() {
		return "¿Desea eliminar el signo del registro de signos?";
	}

	@Override
	public String getDeleteDocument() {
		return "Eliminar documento";
	}

	@Override
	public String getDeleteCollage() {
		return "Eliminar collage";
	}

	@Override
	public String getDeleteUser() {
		return "Eliminar usuario de la sala";
	}

	@Override
	public String getDesignColors() {
		return "Colores de diseño";
	}

	@Override
	public String getDifferentDayLoginBadgeDescription() {
		return "Esta medalla distingue a aquellos usuarios que utilizan con frecuencia desde hace tiempo el editor de delegs.";
	}

	@Override
	public String getDifferentDayLoginBadgeTitle() {
		return "Usuario experimentado";
	}

	@Override
	public String getDiscard() {
		return "Descartar";
	}

	@Override
	public String getLogin() {
		return "Iniciar sesión";
	}

	@Override
	public String getDoYouWantToDiscardTheChanges() {
		return "¿Desea descartar los cambios?";
	}

	@Override
	public String getDoYouWantToSaveTheSignWithANewName() {
		return "¿Desea guardar este signo con un nuevo nombre?";
	}

	@Override
	public String getDocumentCreatorBadgeDescription() {
		return "Esta medalla distingue a aquellos usuarios que han creado un gran número de documentos.";
	}

	@Override
	public String getDocumentCreatorBadgeTitle() {
		return "Documentos profesionales";
	}

	@Override
	public String getDocumentEditor() {
		return "Editor de documentos";
	}

	@Override
	public String getDocumentEditorSidebarName() {
		return "Editar documento";
	}

	@Override
	public String getEarnedOn() {
		return "Obtenida el";
	}

	@Override
	public String getEditBreath() {
		return "Editar flujo de aire";
	}

	@Override
	public String getEditCheeks() {
		return "Editar mejillas";
	}

	@Override
	public String getEditCollection() {
		return "Editar extras";
	}

	@Override
	public String getEditEars() {
		return "Editar orejas";
	}

	@Override
	public String getEditExpression() {
		return "Editar expresión";
	}

	@Override
	public String getEditEyes() {
		return "Editar ojos";
	}

	@Override
	public String getEditFont() {
		return "Personalizar fuente";
	}

	@Override
	public String getEditCollage() {
		return "Editar collage";
	}

	@Override
	public String getEditHair() {
		return "Editar cabellos";
	}

	@Override
	public String getEditHands() {
		return "Editar manos";
	}

	@Override
	public String getEditHead() {
		return "Editar cabeza";
	}

	@Override
	public String getEditJaw() {
		return "Editar mandíbula";
	}

	@Override
	public String getEditLayout() {
		return "Editar imagen";
	}

	@Override
	public String getEditMovement() {
		return "Editar movimiento";
	}

	@Override
	public String getEditNeck() {
		return "Editar cuello";
	}

	@Override
	public String getEditNose() {
		return "Editar nariz";
	}

	@Override
	public String getEditSymbol() {
		return "Editar icono";
	}

	@Override
	public String getEditViseme() {
		return "Editar imagen de la boca";
	}

	@Override
	public String getEditedOn() {
		return "Editado el";
	}

	@Override
	public String getElements() {
		return "Elementos";
	}

	@Override
	public String getEmailAddressNotAvailable() {
		return "La dirección de correo electrónico ya está en uso. Introduzca otra dirección de correo electrónico.";
	}

	@Override
	public String getEmailAdress() {
		return "Dirección de correo electrónico";
	}

	@Override
	public String getErrorOnChangingColorLabels() {
		return "Error al modificar las etiquetas";
	}

	@Override
	public String getErrorOnCreatingNewRoom() {
		return "Error al crear la nueva sala";
	}

	@Override
	public String getErrorOnLoadingArrowSymbolVariations() {
		return "Error al cargar las variaciones del icono de la flecha";
	}

	@Override
	public String getErrorOnLoadingFolder() {
		return "Error al cargar la carpeta";
	}

	@Override
	public String getErrorOnLoadingHandSymbolVariations() {
		return "Error al cargar las variaciones del icono de la mano";
	}

	@Override
	public String getErrorOnLoadingUsers() {
		return "Error al cargar el usuario";
	}

	@Override
	public String getFailMessageAddAdminToRoom() {
		return "No se pudo agregar un responsable a la sala";
	}

	@Override
	public String getFailMessageAddUserToRoom() {
		return "No se pudo agregar un usuario a la sala";
	}

	@Override
	public String getFailMessageBrowserHistory() {
		return "No se pudo cargar el historial del navegador.";
	}

	@Override
	public String getFailMessageBrowserHistoryLoadFailed() {
		return "El historial del navegador no pudo cargar la URL.";
	}

	@Override
	public String getFailMessageDocumentNotFound() {
		return "No se encontró el documento.";
	}

	@Override
	public String getFailMessageFolderNotFound() {
		return "No se encontró la carpeta.";
	}

	@Override
	public String getFailMessageRemoveAdminFromRoom() {
		return "No se pudo eliminar al responsable de la sala";
	}

	@Override
	public String getFailMessageRemoveUserFromRoom() {
		return "No se pudo eliminar al usuario de la sala";
	}

	@Override
	public String getFinger() {
		return "Dedos";
	}

	@Override
	public String getFingerAlphabet() {
		return "Alfabeto manual";
	}

	@Override
	public String getFirstName() {
		return "Nombre";
	}

	@Override
	public String getFolderAlreadyExists() {
		return "La carpeta ya existe";
	}

	@Override
	public String getFontColor() {
		return "Color de fuente";
	}

	@Override
	public String getFontFormating() {
		return "Formatear texto";
	}

	@Override
	public String getFontSize() {
		return "Tamaño de fuente";
	}

	@Override
	public String getFontStyleItalics() {
		return "Cursiva";
	}

	@Override
	public String getFontWeight() {
		return "Negrita";
	}

	@Override
	public String getFrame() {
		return "Marco";
	}

	@Override
	public String getFreeLayout() {
		return "Diseño libre";
	}

	@Override
	public String getFreePositionVisemes() {
		return "Colocar las cabezas libremente";
	}

	@Override
	public String getCollage() {
		return "Collage";
	}

	@Override
	public String getSnippet() {
		return "Sección";
	}

	@Override
	public String getFreeTextBox() {
		return "Cuadro" + "<br>" + "de texto";
	}

	@Override
	public String getFreeTextLine() {
		return "Línea de" + "<br>" + "texto libre";
	}

	@Override
	public String getGlobalSign() {
		return "Signo del diccionario";
	}

	@Override
	public String getGlossWriting() {
		return "Escritura de glosa";
	}

	@Override
	public String getGlossWritingAndAutomaticFreeTextLine() {
		return "Utilizar glosas y líneas automáticas de texto libre";
	}

	@Override
	public String getGlossWritingOnOff() {
		return "Activar/desactivar escritura de glosa";
	}

	@Override
	public String getHelp() {
		return "Ayuda";
	}

	@Override
	public String getHideGrid() {
		return "Ocultar cuadrícula";
	}

	@Override
	public String getHideOlderBadges() {
		return "Ocultar medallas más antiguas";
	}

	@Override
	public String getImage() {
		return "Imagen";
	}

	@Override
	public String getIncreaseZIndex() {
		return "Siguiente nivel";
	}

	@Override
	public String getInsert() {
		return "Agregar";
	}

	@Override
	public String getInsertSymbols() {
		return "Agregar iconos";
	}

	@Override
	public String getInsertText() {
		return "Introducir texto";
	}

	@Override
	public String getInvalidCharacter() {
		return "La entrada contiene caracteres no válidos";
	}

	@Override
	public String getInvalidEmailAddress() {
		return "Dirección de correo electrónico no válida. Seleccione otra dirección de correo electrónico.";
	}

	@Override
	public String getInvalidEmptySign() {
		return "Signo no válido: El signo no debe estar vacío.";
	}

	@Override
	public String getInvalidSearchWord() {
		return "Término de búsqueda no válido";
	}

	@Override
	public String getInvalidSessionLoginDialogMessage() {
		return "Su sesión ha expirado por inactividad.";
	}

	@Override
	public String getInvalidSessionLoginMessage() {
		return "Vuelva a iniciar sesión";
	}

	@Override
	public String getInvalidSessionTitle() {
		return "Sesión expirada";
	}

	@Override
	public String getInvalidUsername() {
		return "Nombre de usuario no válido. Seleccione otro nombre.";
	}

	@Override
	public String getLastName() {
		return "Apellido";
	}

	@Override
	public String getLeaveRoomForever() {
		return "Abandonar definitivamente la sala";
	}

	@Override
	public String getLeaveRoomForeverMessage() {
		return "¿Desea abandonar esta sala?";
	}

	@Override
	public String getLeaveRoomForeverTitle() {
		return "Abandonar sala";
	}

	@Override
	public String getLegsAndArms() {
		return "Piernas y brazos";
	}

	@Override
	public String getLoadNewText() {
		return "Volver a cargar el texto";
	}

	@Override
	public String getLoaded() {
		return "Descargado en";
	}

	@Override
	public String getLocalSign() {
		return "signo local";
	}

	@Override
	public String getLocalSignCreatorBadgeDescription() {
		return "Esta medalla distingue a aquellos usuarios que han creado un gran número signos locales.";
	}

	@Override
	public String getLocalSignCreatorBadgeTitle() {
		return "Signos profesionales";
	}

	@Override
	public String getLoginRequired() {
		return "Es necesario iniciar sesión";
	}

	@Override
	public String getLoginStreakBadgeDescription() {
		return "Esta medalla se otorga a miembros que utilizan el editor de delegs durante muchos días consecutivos.";
	}

	@Override
	public String getLoginStreakBadgeTitle() {
		return "Usuario intensivo";
	}

	@Override
	public String getLongTimeUserBadgeDescription() {
		return "Esta medalla se otorga a aquellas personas que son miembros del editor de delegs desde hace mucho tiempo.";
	}

	@Override
	public String getLongTimeUserBadgeTitle() {
		return "Veterano";
	}

	@Override
	public String getMirrorHands() {
		return "Reflejar manos";
	}

	@Override
	public String getNewPassword() {
		return "Nueva contraseña";
	}

	@Override
	public String getNewRoom() {
		return "Nueva sala";
	}

	@Override
	public String getNewUser() {
		return "Nuevo usuario";
	}

	@Override
	public String getNoDocumentsFound() {
		return "No se pudo encontrar ningún documento.";
	}

	@Override
	public String getNormalPage() {
		return "Página";
	}

	@Override
	public String getNotYetEarned() {
		return "aún no se ha obtenido";
	}

	@Override
	public String getNoviceBadgeDescription() {
		return "Esta medalla se otorga a aquellos miembros que adquieren sus primeras experiencias con las tres herramientas principales del editor de delegs.";
	}

	@Override
	public String getNoviceBadgeStatusForBronze() {
		return "Obtendras la medalla de plata si abres uno de tus documentos.";
	}

	@Override
	public String getNoviceBadgeStatusForNone() {
		return "Obtendras una medalla si creas y guardas tu primer documento.";
	}

	@Override
	public String getNoviceBadgeStatusForSilver() {
		return "Obtendras la medalla de oro si abres el editor de signos. Para ello, haga doble clic sobre un signo del documento.";
	}

	@Override
	public String getNoviceBadgeTitle() {
		return "Novato";
	}

	@Override
	public String getOnReportContent() {
		return "Publicar contenido";
	}

	@Override
	public String getOnReportContentDesision() {
		return "¿Desea publicar el contenido?";
	}

	@Override
	public String getOnReportedContentFailed() {
		return "No se pudo publicar el contenido";
	}

	@Override
	public String getOnReportedContentSuccessfully() {
		return "Contenido publicado correctamente";
	}

	@Override
	public String getOpenSignEditor() {
		return "Abrir editor de signos";
	}

	@Override
	public String getOperationInvalid() {
		return "Operación no válida";
	}

	@Override
	public String getPasswordChanged() {
		return "Se modificó la contraseña";
	}

	@Override
	public String getPasswordForgotten() {
		return "¿Olvidó sus datos de acceso?";
	}

	@Override
	public String getPasswordForgottenInputInvalid() {
		return "Se ha producido un error. Compruebe sus entradas.";
	}

	@Override
	public String getPasswordForgottenNoEmailAddress() {
		return "No ha introducido ninguna dirección de correo electrónico. Póngase en contacto con el administrador del sistema enviando un correo electrónico a admin@delegs.de";
	}

	@Override
	public String getPasswordForgottenSentMail() {
		return "Se envío un enlace para modificar sus datos de acceso a la dirección de correo electrónico registrada.";
	}

	@Override
	public String getPasswordForgottenSubjectForUser() {
		return "Nuevos datos de acceso de delegs.de";
	}

	@Override
	public String getPermissionToSaveDeniedTitle() {
		return "No se puede guardar";
	}

	@Override
	public String getPleaseEnterValidRoomName() {
		return "Introduzca un nombre de sala válido.";
	}

	@Override
	public String getPleaseEnterValidUsernames() {
		return "Introduzca un nombre de usuario no válido.";
	}

	@Override
	public String getPositionHeadSymbols() {
		return "Colocar las cabezas";
	}

	@Override
	public String getPrivacyPolicyAgreement() {
		// TODO Übersetzen
		return "I accept the privacy policy.";
	}

	@Override
	public String getRegistrationNoPrivacyPolicyAgreement() {
		// TODO Übersetzen
		return "You have to accept our privacy policy to register an account.";
	}

	@Override
	public String getAgeVerification() {
		// TODO Übersetzen
		return "I am 16 years old or older or have the consent of a legal guardian.";
	}

	@Override
	public String getRegistrationNoAgeVerification() {
		// TODO Übersetzen
		return "You must be over 16 years of age or have the consent of a parent or guardian to register.";
	}

	@Override
	public String getPrivacyPolicyUpdate() {
		// TODO Übersetzen
		return "We have updated our privacy policy!";
	}

	@Override
	public String getPrivacyPolicyUpdateMessage() {
		// TODO Übersetzen
		return "Do you agree to the new privacy policy?";
	}

	@Override
	public String getPrivacyPolicy() {
		// TODO Übersetzen
		return "Privacy Policy";
	}

	@Override
	public String getPrivacyPolicyText() {
		// TODO Übersetzen
		return "PLATZHALTER";
	}

	@Override
	public String getOpenPrivacyPolicy() {
		// TODO Übersetzen
		return "Open privacy policy";
	}

	public String getImprint() {
		return "Aviso legal";
	}

	@Override
	public String getImprintText() {
		return "PLATZHALTER";
	}

	@Override
	public String getPrivateRoom() {
		return "Sala privada";
	}

	@Override
	public String getRecentlyReceivedBadges() {
		return "Última medalla adquirida";
	}

	@Override
	public String getRecommendedNextBadges() {
		return "Medalla recomendada";
	}

	@Override
	public String getRedo() {
		return "Repetir";
	}

	@Override
	public String getSignUp() {
		return "Registrar";
	}

	@Override
	public String getRegistrationError() {
		return "Error al registrarse";
	}

	@Override
	public String getRegistrationInvalidFirstNameField() {
		return "Introduzca un nombre";
	}

	@Override
	public String getRegistrationInvalidLastNameField() {
		return "Introduzca un apellido";
	}

	@Override
	public String getRegistrationInvalidMailAddress() {
		return "Introduzca una dirección de correo electrónico válida";
	}

	@Override
	public String getRegistrationInvalidPassword() {
		return "Contraseña no válida (mín. 6 caracteres, letras, números y caracteres especiales)";
	}

	@Override
	public String getRegistrationInvalidUserName() {
		return "Nombre de usuario no válido";
	}

	@Override
	public String getRegistrationNotPossible() {
		return "No se puede registrar";
	}

	@Override
	public String getRegistrationPasswordMismatch() {
		return "Las contraseñas no concuerdan";
	}

	@Override
	public String getRemovedAdminFromRoomSuccessfully() {
		return "El usuario ya no es responsable de la sala";
	}

	@Override
	public String getRemovedUserFromRoomSuccessfully() {
		return "El usuario fue eliminado correctamente de la sala";
	}

	@Override
	public String getRenameDocument() {
		return "Renombrar el documento";
	}

	@Override
	public String getRepeatNewPassword() {
		return "Volver a introducir una nueva contraseña";
	}

	@Override
	public String getReplace() {
		return "Reemplazar";
	}

	@Override
	public String getReportButtonTitle() {
		return "Publicar";
	}

	@Override
	public String getRoomAdminManagement() {
		return "Agregar/eliminar responsable";
	}

	@Override
	public String getRoomManagement() {
		return "Administración de la sala";
	}

	@Override
	public String getRoomName() {
		return "Nombre de la sala";
	}

	@Override
	public String getRoomNameDuplicateWarning() {
		return "Ya existe una sala con este nombre. <br/> ¿Desea crear una nueva sala con el mismo nombre?";
	}

	@Override
	public String getRoomPolicyCollective() {
		return "Acceso completo";
	}

	@Override
	public String getRoomPolicyIndividual() {
		return "Acceso privado";
	}

	@Override
	public String getRoomPolicyManagement() {
		return "Cambiar la ordenación de la sala";
	}

	@Override
	public String getRoomPolicyShared() {
		return "Acceso limitado";
	}

	@Override
	public String getRoomPolicyShowroom() {
		return "Acceso de lectura";
	}

	@Override
	public String getRoomPolicyShowroomLongDescription() {
		return "Sólo se pueden leer los documentos";
	}

	@Override
	public String getRoomUserDeleteTitle() {
		return "Eliminar usuario de la sala";
	}

	@Override
	public String getRoomUserManagement() {
		return "Agregar/eliminar usuario de la sala";
	}

	@Override
	public String getRoomVisibilityInfo() {
		return "Visible para todos";
	}

	@Override
	public String getRoomVisibilityManagement() {
		return "Modificar la visibilidad de la sala";
	}

	@Override
	public String getRoomnameCollision() {
		return "Nombre de sala ya asignado";
	}

	@Override
	public String getSaveDocument() {
		return "Guardar documento";
	}

	@Override
	public String getSaveInDocumentOnly() {
		return "guardar sólo en el documento";
	}

	@Override
	public String getSaveNew() {
		return "Volver a guardar";
	}

	@Override
	public String getSearchButtonText() {
		return "Buscar";
	}

	@Override
	public String getSearchForDocument() {
		return "Buscar documento";
	}

	@Override
	public String getSearchWord() {
		return "Palabra de búsqueda";
	}

	@Override
	public String getSelectDictionary() {
		return "Diccionario";
	}

	@Override
	public String getServiceNotAvailable() {
		return "El servicio no está actualmente disponible. Vuelva a intentarlo más tarde.";
	}

	@Override
	public String getShouldersAndHip() {
		return "Hombros y caderas";
	}

	@Override
	public String getShowGrid() {
		return "Mostrar cuadrícula";
	}

	@Override
	public String getShowOlderBadges() {
		return "Mostrar medallas más antiguas";
	}

	@Override
	public String getSignItem() {
		return "Signo";
	}

	@Override
	public String getSkinColors() {
		return "Colores de la piel";
	}

	@Override
	public String getSpellSearchwordToFingerAlphabet() {
		return "Deletrear palabra de búsqueda";
	}

	@Override
	public String getStandardColors() {
		return "Colores estándar";
	}

	@Override
	public String getStayInEditor() {
		return "Permanecer en el editor";
	}

	@Override
	public String getTechnicalError() {
		return "Se ha producido un error técnico.";
	}

	@Override
	public String getToggleSearchWordVisibility() {
		return "Mostrar y ocultar líneas de palabra de búsqueda";
	}

	@Override
	public String getTokenCountInfoToolTipTextForRegisteredUser() {
		return "Número de elementos en este documento";
	}

	@Override
	public String getTokenCountMaxElementsText() {
		return "Elementos máx.";
	}

	@Override
	public String getTopView() {
		return "Vista superior";
	}

	@Override
	public String getUndo() {
		return "Deshacer";
	}

	@Override
	public String getUnsavedSign() {
		return "Signo editado pero no guardado aún.";
	}

	@Override
	public String getUserAddedToRoomSuccessfully() {
		return "Usuario agregado correctamente a la sala";
	}

	@Override
	public String getUserNameNotAvailable() {
		return "Nombre de usuario no disponible. Seleccione otro nombre.";
	}

	@Override
	public String getUserNameOrEmailAddress() {
		return "Introduzca un nombre de usuario o la dirección de correo electrónico registrada";
	}

	@Override
	public String getValidationEmailSubjectForUser() {
		return "Activar cuenta de delegs";
	}

	@Override
	public String getVideo() {
		return "Vídeo";
	}

	@Override
	public String getYourBadges() {
		return "Tus medallas";
	}

	@Override
	public String getValidationEmailTextForUser(String userName, String validationUrlString) {
		return "¡Bienvenido a delegs, " + userName + "!\n\nSigue el enlace para activar tu cuenta.\n\n"
				+ validationUrlString + "\n\nSaludos\nEl equipo de delegs\nwww.delegs.de\ninfo@delegs.de";
	}

	@Override
	public String getRegistrationDialogueMessageTextForUser(String firstname, String lastname) {
		return "Bienvenido, " + firstname + " " + lastname
				+ "<br />Para completar el registro siga el enlace de activación en el correo electrónico que le hemos enviado.";
	}

	@Override
	public String getPasswordForgottenEmailTextForUser(String username, String link) {
		return "¡Hola " + username + "!\n\nPara modificar su contraseña, siga este enlace:\n\n" + link
				+ "\n\nSaludos\ninfo@delegs.de";
	}

	@Override
	public String getRegister() {
		return "Registrar";
	}

	@Override
	public String getInsertDeleteAndResizeToken() {
		return "Insertar, eliminar y modificar la fuente de elementos";
	}

	@Override
	public String getDelegsCopyright() {
		return "© delegs.de";
	}

	@Override
	public String getTooltipRoomOwnerTextBox() {
		return "Introducir un responsable de la sala. Para introducir varios responsables, se deben separar con punto y coma \";\".";
	}

	@Override
	public String getDifferentDayLoginBadgeStatusForNone(long x) {
		if (x == 1) {
			return "Obtendras una medalla si utilizas durante otro día el editor de delegs.";
		} else {
			return "Obtendras una medalla si utilizas en " + x + " días adicionales el editor de delegs.";
		}
	}

	@Override
	public String getDifferentDayLoginBadgeStatusForBronze(long x) {
		if (x == 1) {
			return "Obtendras la medalla de plata si utilizas durante otro día el editor de delegs.";
		} else {
			return "Obtendras la medalla de plata si utilizas en " + x + " días el editor de delegs.";
		}
	}

	@Override
	public String getDifferentDayLoginBadgeStatusForSilver(long x) {
		if (x == 1) {
			return "Obtendras la medalla de oro si utilizas durante otro día el editor de delegs.";
		} else {
			return "Obtendras la medalla de oro si utilizas en " + x + " días el editor de delegs.";
		}
	}

	@Override
	public String getLocalSignCreatorBadgeStatusForNone(long x) {
		if (x == 1) {
			return "Obtendras una medalla si creas otro signo local.";
		} else {
			return "Obtendras una medalla si creas " + x + " signo local.";
		}
	}

	@Override
	public String getLocalSignCreatorBadgeStatusForBronze(long x) {
		if (x == 1) {
			return "Obtendras la medalla de plata si creas otro signo local.";
		} else {
			return "Obtendras la medalla de plata si creas " + x + " signo local.";
		}
	}

	@Override
	public String getLocalSignCreatorBadgeStatusForSilver(long x) {
		if (x == 1) {
			return "Obtendras la medalla de oro si creas otro signo local.";
		} else {
			return "Obtendras la medalla de oro si creas " + x + " signo local.";
		}
	}

	@Override
	public String getLongTimeUserBadgeStatusForNone(long x) {
		if (x == 1) {
			return "Obtendras una medalla si permaneces registrado otro día más.";
		} else {
			return "Obtendras una medalla si permaneces registrado " + x + " días más.";
		}
	}

	@Override
	public String getLongTimeUserBadgeStatusForBronze(long x) {
		if (x == 1) {
			return "Obtendras la medalla de plata si permaneces registrado otro día más.";
		} else {
			return "Obtendras la medalla de plata si permaneces registrado" + x + " días más.";
		}
	}

	@Override
	public String getLongTimeUserBadgeStatusForSilver(long x) {
		if (x == 1) {
			return "Obtendras la medalla de oro si permaneces registrado otro día más.";
		} else {
			return "Obtendras la medalla de oro si permaneces registrado " + x + " días más.";
		}
	}

	@Override
	public String getLoginStreakBadgeStatusForNone(long x) {
		if (x == 1) {
			return "Obtendras una medalla si mañana utilizas el editor de delegs.";
		} else {
			return "";// TODO Übersetzen
		}
	}

	@Override
	public String getLoginStreakBadgeStatusForBronze(long x) {
		if (x == 1) {
			return "Obtendras la medalla de plata si mañana utilizas el editor de delegs.";
		} else {
			return "";// TODO Übersetzen
		}
	}

	@Override
	public String getLoginStreakBadgeStatusForSilver(long x) {
		if (x == 1) {
			return "Obtendras la medalla de oro si mañana utilizas el editor de delegs.";
		} else {
			return "";// TODO Übersetzen
		}
	}

	@Override
	public String getDocumentCreatorBadgeStatusForNone(long x) {
		if (x == 1) {
			return "Para obtener una medalla debes crear otro documento.";
		} else {
			return "Para obtener una medalla debes crear " + x + " documento.";
		}
	}

	@Override
	public String getDocumentCreatorBadgeStatusForBronze(long x) {
		if (x == 1) {
			return "Para obtener la medalla de plata debes crear otro documento.";
		} else {
			return "Para obtener la medalla de plata debes crear " + x + " documento.";
		}
	}

	@Override
	public String getDocumentCreatorBadgeStatusForSilver(long x) {
		if (x == 1) {
			return "Para obtener la medalla de oro debes crear otro documento.";
		} else {
			return "Para obtener la medalla de oro debes crear " + x + " documento.";
		}
	}

	@Override
	public String getRoomUserDeleteMessage(String user) {
		return "¿Desea eliminar al usuario de la sala, " + user + "?";
	}

	@Override
	public String getPermissionToSaveDeniedBecauseOfTooManyTokens() {
		return "Su documento contiene demasiados elementos.<br/>Inicie sesión para poder guardar documentos de mayor tamaño.";
	}

	@Override
	public String getTokenCountInfoToolTipTextForUnknownUser() {
		return "Como usuario no registrado, puede guardar documentos con hasta mil elementos.<br/>Inicie sesión para poder guardar documentos de mayor tamaño.";
	}

	@Override
	public String getShowRoomName() {
		// TODO Übersetzen
		return "Showroom";
	}

	@Override
	public String getMissingAuthorization() {
		// TODO Übersetzen
		return "Missing Authorization.";
	}

	@Override
	public String getDeleteSignNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to delete signs from the global dictionary.";
	}

	@Override
	public String getSaveSignNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to store signs in the global dictionary.";
	}

	@Override
	public String getAddUserToRoomNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to add a user to this room.";
	}

	@Override
	public String getDeleteUserToRoomNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to remove a user from this room.";
	}

	@Override
	public String getAddAdminToRoomNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to add an admin to this room.";
	}

	@Override
	public String getDeleteAdminToRoomNotAllowed() {
		// TODO Übersetzen
		return "You are not authorized to remove an admin from this room.";
	}

	@Override
	public String getPermissionForActionDenied() {
		// TODO Übersetzen
		return "You are not authorized to perform this action.";
	}

	@Override
	public String getRoomDescription() {
		return "Descripción de la habitación";
	}

	@Override
	public String getImageNotFound() {
		// TODO Übersetzen
		return "no se ha encontrado ninguna imagen";
	}

	@Override
	public String getImageTooLarge() {
		// TODO Übersetzen
		return "imagen demasiado grande";
	}

	@Override
	public String getWebsideNotSupported() {
		// TODO Übersetzen
		return "side not supported";
	}

	@Override
	public String getNoVideoFound() {
		// TODO Übersetzen
		return "no se ha encontrado ningún vídeo";
	}

	@Override
	// TODO übersetzen
	public String getEditVideoToken() {
		return "Edit video";
	}

	@Override
	public String getUpload() {
		return "Upload";
	}

	@Override
	public String getEditImageToken() {
		// TODO Übersetzen
		return "Edit image";
	}

	@Override
	public String getMaxVideoLenghtMessage(int i) {
		// TODO Übersetzen
		return "The allowed video length of " + i + " seconds was exceeded.";
	}

	@Override
	public String getVideoFormatMessage() {
		// TODO Übersetzen
		return "Only videofiles can be uploaded.";
	}

	@Override
	public String getVideoRecordInstructions() {
		// TODO Übersetzen
		return "Click the start button to begin recording a video for 5 seconds.<br> "
				+ "You can stop the video by clicking the stop button. If you already recorded a video <br> "
				+ "you can repeat the recording by clicking the button again.";
	}

	@Override
	public String getVideoRecorderCaption() {
		// TODO Übersetzen
		return "Videorecording";
	}

	@Override
	public String getStartVideoRecorder() {
		// TODO Übersetzen
		return "Start recording";
	}

	@Override
	public String getStopVideoRecorder() {
		// TODO Übersetzen
		return "Stop recording";
	}

	@Override
	public String getVideoFileName() {
		// TODO Übersetzen
		return "Video-filename: ";
	}

	@Override
	public String getVideoRecordingCountDown(int counter) {
		// TODO Übersetzen
		String countdown = "";
		if (counter > 1) {
			countdown = "recording starts in " + counter + " seconds ...";
		} else {
			countdown = "recording starts in " + counter + " second ...";
		}
		return countdown;
	}

	@Override
	public String getRecordingForXSeconds(int counter) {
		String countdown = "";
		if (counter > 1) {
			countdown = "recording for " + counter + " seconds ...";
		} else {
			countdown = "recording for " + counter + " second ...";
		}
		return countdown;
	}

	@Override
	public String getVideoRecording() {
		// TODO Übersetzen
		return "Record" + "<br>" + "video";
	}

	@Override
	public String getBrowserNotSupported() {
		return "Browser not supported. Please use Firefox or Chrome.";
	}

	@Override
	public String getVideoRecordingSuccessfull() {
		// TODO Übersetzen
		return "video recorded successfully.";
	}

	@Override
	public String getDefaultVideoFileName() {
		// TODO Übersetzen
		return "newVideo";
	}

	@Override
	public String getErrorNoCameraFound() {
		// TODO Übersetzen
		return "No camera found. Please connect a camera";
	}

	@Override
	public String getCameraPermissionDenied() {
		// TODO Übersetzen
		return "Your browser settings prohibit the usage of your camera. \nPlease allow the usage of your camera to record a video.";
	}

	@Override
	public String getCameraAlreadyInUse() {
		// TODO Übersetzen
		return "Your camera is already in use by another application. \nPlease close the other application to record a video.\n"
				+ " \nIf all other applications are closed, \nyou might have to check your system settings.";
	}

	@Override
	public String getReStartVideoRecorder() {
		// TODO Übersetzen
		return "Repeat recording";
	}

	@Override
	public String getProgressBarTextAbove() {
		// TODO Übersetzen
		return "Video is uploading";
	}

	@Override
	public String getProgressBarTextUnder() {
		// TODO Übersetzen
		return "You can still edit the document.<br> " + "Please save the document after the upload is finished.";
	}

	public String getUrlLabel() {
		// TODO Übersetzen
		return "Url: ";
	}

	@Override
	public String getVideoUrlPlaceholder() {
		// TODO Übersetzen
		return "Enter video url here";
	}

	@Override
	public String getImageUrlPlaceholder() {
		// TODO Übersetzen
		return "Enter image url here";
	}

	@Override
	public String getNoVideoLoaded() {
		// TODO Übersetzen
		return "No video loaded yet";
	}

	public String getVideoConverting() {
		// TODO Übersetzen
		return "Video is converting";
	}

	@Override
	public String getCLickCtrlLeftToOpen() {
		// TODO Übersetzen
		return "Click ctrl + left-click to open the following link in a new tab:\n\n";
	}

	@Override
	public String getPrevDocument() {
		// TODO Übersetzen
		return "Previous Document";
	}

	@Override
	public String getNextDocument() {
		// TODO Übersetzen
		return "Next Document";
	}
}
