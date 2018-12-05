LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'operLog',
} : {}), {
  i18nKey : 'appApiRequestLogMgmt',
  $appendTo : true,
  cols : 6,
  url : '/ROOT_GetAppApiRequestLogPage',
  columns : [
      {
        text : 'appKey',
        width : 150,
        name : 'appKey'
      }, {
        text : 'clientType',
        width : 100,
        name : 'clientType'
      }, {
        text : 'loginName',
        width : 120,
        name : 'loginName'
      }, {
        text : 'cellphone',
        width : 100,
        name : 'cellphone'
      }, {
        text : 'userName',
        width : 80,
        name : 'userName'
      }, {
        text : 'versions',
        width : 100,
        formatter : function(rowData) {
          return rowData.versionX + '.' + rowData.versionY + '.' + rowData.versionZ;
        }
      }, {
        text : 'locale',
        width : 80,
        name : 'locale'
      }, {
        text : 'osVersion',
        width : 150,
        name : 'osVersion'
      }, {
        text : 'brand',
        width : null,
        name : 'brand'
      }, {
        text : 'model',
        width : 120,
        name : 'model'
      }, {
        text : 'uuid',
        width : 150,
        name : 'uuid'
      }, {
        text : 'screenWidth',
        width : 80,
        name : 'screenWidth'
      }, {
        text : 'screenHeight',
        width : 80,
        name : 'screenHeight'
      }, {
        text : 'insertTime',
        width : 160,
        formatter : function(rowData) {
          return showStandardTime(rowData.insertTime);
        }
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
