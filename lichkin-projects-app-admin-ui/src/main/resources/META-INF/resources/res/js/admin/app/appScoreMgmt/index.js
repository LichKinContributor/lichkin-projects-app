LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'appScoreMgmt',
} : {}), {
  i18nKey : 'appScoreMgmt',
  $appendTo : true,
  cols : 4,
  url : '/SysAppScore/P',
  columns : [
      {
        text : 'clientType',
        width : 160,
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
        width : 160,
        formatter : function(rowData) {
          if (rowData.cellphone == null) {
            return '';
          }
          return rowData.cellphone;
        }
      }, {
        text : 'title',
        width : 200,
        name : 'title'
      }, {
        text : 'score',
        width : 50,
        name : 'score'
      }, {
        text : 'insertTime',
        width : 160,
        formatter : function(rowData) {
          return formatterTime(rowData.insertTime);
        }
      }, {
        text : 'content',
        width : null,
        name : 'content'
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
          },
          validator : true
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
