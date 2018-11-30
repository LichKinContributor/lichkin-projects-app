LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'appSignInLogMgmt',
} : {}), {
  i18nKey : 'appSignInLogMgmt',
  $appendTo : true,
  cols : 6,
  url : '/ROOT_GetAppSignInLogPage',
  columns : [
      {
        text : 'appKey',
        width : 100,
        name : 'appKey'
      }, {
        text : 'clientType',
        width : 80,
        name : 'clientType'
      }, {
        text : 'version',
        width : 100,
        formatter : function(rowData) {
          return rowData.versionX + '.' + rowData.versionY + '.' + rowData.versionZ;
        }
      }, {
        text : 'loginName',
        width : 200,
        formatter : function(rowData) {
          if (rowData.loginName == null) {
            return '';
          }
          return rowData.loginName;
        }
      }, {
        text : 'cellphone',
        width : 100,
        formatter : function(rowData) {
          if (rowData.cellphone == null) {
            return '';
          }
          return rowData.cellphone;
        }
      }, {
        text : 'userName',
        width : 80,
        formatter : function(rowData) {
          if (rowData.userName == null) {
            return '';
          }
          return rowData.userName;
        }
      }, {
        text : 'signDate',
        width : 200,
        name : 'signDate'
      }
  ],
  pageable : true,
  searchForm : [
      {
        plugin : 'droplist',
        options : {
          key : 'appKey',
          name : 'appKey',
          param : {
            categoryCode : 'APP_KEY'
          }
        }
      }, {
        plugin : 'droplist',
        options : {
          key : 'clientType',
          name : 'clientType',
          param : {
            categoryCode : 'CLIENT_TYPE',
            excludes : 'JAVASCRIPT'
          }
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'loginName',
          cls : 'fuzzy-left fuzzy-right'
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'cellphone',
          cls : 'fuzzy-right'
        }
      }, {
        plugin : 'datepicker',
        options : {
          name : 'startDate'
        }
      }, {
        plugin : 'datepicker',
        options : {
          name : 'endDate'
        }
      }
  ]
}));
