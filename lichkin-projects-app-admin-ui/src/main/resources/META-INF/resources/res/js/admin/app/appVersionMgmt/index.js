var appVersionMgmtAddForm = {
  plugins : [
      {
        plugin : 'droplist',
        options : {
          name : 'appKey',
          param : {
            categoryCode : 'APP_KEY'
          },
          validator : true
        }
      }, {
        plugin : 'droplist',
        options : {
          name : 'clientType',
          param : {
            categoryCode : 'CLIENT_TYPE',
            excludes : 'JAVASCRIPT'
          },
          validator : true
        }
      }, {
        plugin : 'droplist',
        options : {
          name : 'forceUpdate',
          data : [
            {
              text : $.LKGetI18N('FORCE_UPDATE', 'false'),
              value : 'false'
            }
          ],
          readonly : true,
          commitable : true,
          value : false
        }
      }, {
        plugin : 'numberspinner',
        options : {
          name : 'versionX',
          validator : true,
          min : 0,
          max : 127
        }
      }, {
        plugin : 'numberspinner',
        options : {
          name : 'versionY',
          validator : true,
          min : 0,
          max : 127
        }
      }, {
        plugin : 'numberspinner',
        options : {
          name : 'versionZ',
          validator : true,
          min : 1,
          max : 999
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'url',
          validator : 'required,url',
          cols : 3,
          maxlength : 128
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'tip',
          cols : 3,
          rows : 2,
          validator : true,
          maxlength : 64
        }
      }
  ]
};

var appVersionMgmtEditForm = {
  url : '/SysAppVersion/O',
  plugins : [
      {
        plugin : 'droplist',
        options : {
          name : 'forceUpdate',
          data : [
              {
                text : $.LKGetI18N('FORCE_UPDATE', 'true'),
                value : 'true'
              }, {
                text : $.LKGetI18N('FORCE_UPDATE', 'false'),
                value : 'false'
              }
          ],
          validator : true
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'url',
          validator : 'required,url',
          cols : 2,
          maxlength : 128
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'tip',
          cols : 2,
          rows : 2,
          validator : true,
          maxlength : 64
        }
      }
  ]
};

LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'appVersionMgmt',
} : {}), {
  i18nKey : 'appVersionMgmt',
  $appendTo : true,
  cols : 5,
  url : '/SysAppVersion/P',
  columns : [
      {
        text : 'clientType',
        width : 80,
        name : 'clientType'
      }, {
        text : 'version',
        width : 80,
        formatter : function(rowData) {
          return rowData.versionX + '.' + rowData.versionY + '.' + rowData.versionZ;
        }
      }, {
        text : 'forceUpdate',
        width : 60,
        formatter : function(rowData) {
          return $.LKGetI18N('FORCE_UPDATE', rowData.forceUpdate);
        }
      }, {
        text : 'usingStatus',
        width : 60,
        name : 'usingStatus'
      }, {
        text : 'url',
        width : '2/5',
        name : 'url',
        textAlign : 'left'
      }, {
        text : 'tip',
        width : '3/5',
        name : 'tip',
        textAlign : 'left'
      }
  ],
  pageable : true,
  toolsAdd : {
    saveUrl : '/SysAppVersion/I',
    dialog : {
      size : {
        cols : 3,
        rows : 5
      }
    },
    form : appVersionMgmtAddForm
  },
  toolsEdit : {
    saveUrl : '/SysAppVersion/U',
    dialog : {
      size : {
        cols : 2,
        rows : 4
      }
    },
    form : appVersionMgmtEditForm
  },
  toolsRemove : {
    saveUrl : '/SysAppVersion/D',
    allowUsingStatusArr : [
      {
        usingStatus : 'STAND_BY',
        errorMsg : 'only stand by status can be remove'
      }
    ],
    disallowUsingStatusArr : [
      {
        usingStatus : 'DEPRECATED',
        errorMsg : 'already removed'
      }
    ]
  },
  toolsSubmit : {
    icon : 'release',
    text : 'release',
    saveUrl : '/SysAppVersion/US',
    allowUsingStatusArr : [
      {
        usingStatus : 'STAND_BY',
        errorMsg : 'only stand by status can be release'
      }
    ],
    disallowUsingStatusArr : [
      {
        usingStatus : 'USING',
        errorMsg : 'already using'
      }
    ]
  },
  searchForm : [
      {
        plugin : 'droplist',
        options : {
          name : 'appKey',
          param : {
            categoryCode : 'APP_KEY'
          },
          validator : true
        }
      }, {
        plugin : 'droplist',
        options : {
          name : 'clientType',
          param : {
            categoryCode : 'CLIENT_TYPE',
            includes : 'ANDROID' + LK.SPLITOR + 'IOS'
          },
        }
      }, {
        plugin : 'droplist',
        options : {
          name : 'usingStatus',
          param : {
            categoryCode : 'APP_VERSION_USING_STATUS',
            includes : 'STAND_BY' + LK.SPLITOR + 'USING'
          }
        }
      }
  ]
}));
