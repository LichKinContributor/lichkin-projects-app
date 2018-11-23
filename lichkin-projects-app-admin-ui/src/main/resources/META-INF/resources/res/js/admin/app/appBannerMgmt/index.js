var appBannerMgmtFormPlugins = LK.UI.formUtils.newPlugins(null, [
    {
      plugin : 'cropper',
      options : {
        name : 'banner',
        cols : 2,
        rows : 6,
        validator : true,
        compressWidth : 512,
        compressHeight : 288
      }
    }, {
      plugin : 'droplist',
      options : {
        key : 'appKey',
        name : 'appKey',
        validator : true,
        param : {
          categoryCode : 'APP_KEY'
        },
        linkages : [
            'clientType', 'versions'
        ]
      }
    }, {
      plugin : 'droplist',
      options : {
        key : 'clientType',
        name : 'clientType',
        validator : true,
        url : '/SysAppVersion/LD',
        linkages : [
          'versions'
        ],
        onLinkaged : function($plugin, linkage) {
          switch (linkage.linkageName) {
            case 'appKey':
              if (linkage.linkageValue == '') {
                $plugin.LKClearDatas();
              } else {
                $plugin.LKLoad({
                  param : {
                    appKey : linkage.linkageValue
                  }
                }, linkage);
              }
              break;
          }
        }
      }
    }, {
      plugin : 'droplist',
      options : {
        key : 'version',
        name : 'versions',
        url : '/SysAppVersion/LD01',
        multiSelect : true,
        onLinkaged : function($plugin, linkage) {
          switch (linkage.linkageName) {
            case 'appKey':
              $plugin.LKClearDatas();
              break;
            case 'clientType':
              if (linkage.linkageValue == '') {
                $plugin.LKClearDatas();
              } else {
                $plugin.LKLoad({
                  param : {
                    appKey : $plugin.LKGetSiblingPlugin('appKey').LKGetValue(),
                    clientType : linkage.linkageValue
                  }
                }, linkage);
              }
              break;
          }
        }
      }
    }, {
      plugin : 'textbox',
      options : {
        name : 'keywords',
        maxlength : 64
      }
    }, {
      plugin : 'textbox',
      options : {
        name : 'author',
        maxlength : 64
      }
    }, {
      plugin : 'numberspinner',
      options : {
        name : 'orderId',
        value : 0,
        min : 0,
        max : 127
      }
    }, {
      plugin : 'textbox',
      options : {
        name : 'title',
        cols : 2,
        validator : true,
        maxlength : 64
      }
    }, {
      plugin : 'textbox',
      options : {
        name : 'brief',
        cols : 2,
        rows : 2,
        maxlength : 128
      }
    }
]);

var appBannerMgmtContentAddFormPlugins = LK.UI.formUtils.newPlugins(appBannerMgmtFormPlugins, {
  plugin : 'ueditor',
  options : {
    name : 'content',
    cols : 4,
    validator : true
  }
});

var appBannerMgmtLinkAddForm = LK.UI.formUtils.newPlugins(appBannerMgmtFormPlugins, {
  plugin : 'textbox',
  options : {
    name : 'linkUrl',
    cols : 4,
    validator : 'required,url',
    maxlength : 512
  }
});

LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'appBannerMgmt',
} : {}), {
  i18nKey : 'appBannerMgmt',
  $appendTo : true,
  cols : 4,
  url : '/SysAppBanner/P',
  columns : [
      {
        text : 'banner',
        width : 300,
        formatter : function(rowData, $plugin, options, $container, level, columns, treeFieldName, i18nKey) {
          return {
            plugin : 'cropper',
            options : {
              name : 'banner',
              compressWidth : 512,
              compressHeight : 288,
              value : rowData.banner,
              readonly : true
            }
          };
        }
      }, {
        text : 'title',
        width : null,
        name : 'title',
        textAlign : 'left',
      }, {
        text : 'newsType',
        width : 80,
        formatter : function(rowData, $plugin, options, $container, level, columns, treeFieldName, i18nKey) {
          if (rowData.linkUrl) {
            return $.LKGetI18N(i18nKey + 'NEWS_TYPE.linkUrl');
          }
          return $.LKGetI18N(i18nKey + 'NEWS_TYPE.content');
        }
      }, {
        text : 'clientType',
        width : 80,
        name : 'clientType'
      }, {
        text : 'usingStatus',
        width : 80,
        name : 'usingStatus',
      }, {
        text : 'version',
        width : 300,
        formatter : function(rowData, $plugin, options, $container, level, columns, treeFieldName, i18nKey) {
          if (rowData.versions) {
            return rowData.versions.replace(new RegExp(LK.SPLITOR, "g"), ';').substr(1);
          }
          return $.LKGetI18N(i18nKey + 'VERSION.ALL');
        }
      }
  ],
  pageable : true,
  toolsAdd : [
      {
        text : 'addLinkUrl',
        saveUrl : '/SysAppBanner/I',
        dialog : {
          size : {
            cols : 4,
            rows : 7
          }
        },
        form : {
          plugins : appBannerMgmtLinkAddForm
        }
      }, {
        text : 'addContent',
        saveUrl : '/SysAppBanner/I',
        dialog : {
          size : {
            cols : 4,
            rows : 20
          }
        },
        form : {
          plugins : appBannerMgmtContentAddFormPlugins
        }
      }
  ],
  toolsEdit : {
    beforeOpenDialog : function(editJson, $button, $datagrid, $selecteds, selectedDatas, value) {
      if (selectedDatas.linkUrl) {
        return {
          saveUrl : '/SysAppBanner/U',
          dialog : {
            size : {
              cols : 4,
              rows : 7
            }
          },
          form : {
            url : '/SysAppBanner/O',
            plugins : LK.UI.formUtils.newReadonlyPlugins(appBannerMgmtLinkAddForm, [
                'appKey', 'clientType'
            ])
          }
        }
      }
      return {
        saveUrl : '/SysAppBanner/U',
        dialog : {
          size : {
            cols : 4,
            rows : 20
          }
        },
        form : {
          url : '/SysAppBanner/O',
          plugins : LK.UI.formUtils.newReadonlyPlugins(appBannerMgmtContentAddFormPlugins, [
              'appKey', 'clientType'
          ])
        }
      }
    }
  },
  toolsRemove : {
    saveUrl : '/SysAppBanner/D',
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
  toolsView : {
    beforeOpenDialog : function(viewJson, $button, $datagrid, $selecteds, selectedDatas, value) {
      if (selectedDatas.linkUrl) {
        return {
          dialog : {
            size : {
              cols : 4,
              rows : 7
            }
          },
          form : {
            url : '/SysAppBanner/O',
            plugins : LK.UI.formUtils.newReadonlyPlugins(appBannerMgmtLinkAddForm)
          }
        }
      }
      return {
        dialog : {
          size : {
            cols : 4,
            rows : 20
          }
        },
        form : {
          url : '/SysAppBanner/O',
          plugins : LK.UI.formUtils.newReadonlyPlugins(appBannerMgmtContentAddFormPlugins)
        }
      }
    }
  },
  tools : [
    {
      singleCheck : false,
      icon : 'release',
      text : 'release',
      click : function($button, $plugin, $selecteds, selectedDatas, value, i18nKey) {
        for (var i = 0; i < selectedDatas.length; i++) {
          if (selectedDatas[i].usingStatusDictCode != 'STAND_BY') {
            $plugin.alert('only stand by status can be release');
            return;
          }
        }

        LK.UI.openDialog($.extend({}, {
          size : {
            cols : 1,
            rows : 1
          }
        }, {
          title : 'release',
          icon : 'release',
          mask : true,
          buttons : [
              {
                text : 'ok',
                icon : 'ok',
                cls : 'warning',
                click : function($button, $dialog, $contentBar) {
                  var $form = $contentBar.find('form');
                  if ($form.LKValidate()) {
                    LK.confirm(i18nKey + 'confirm.release', function() {
                      LK.ajax({
                        url : '/SysAppBanner/US',
                        data : {
                          id : value,
                          usingStatus : 'USING',
                          templateCode : $form.find('input[name=templateCode]').val()
                        },
                        showSuccess : true,
                        success : function() {
                          $dialog.LKCloseDialog();
                          $plugin.LKLoad();
                        }
                      });
                    });
                  }
                }
              }, {
                text : 'cancel',
                icon : 'cancel',
                cls : 'danger',
                click : function($button, $dialog, $contentBar) {
                  $dialog.LKCloseDialog();
                }
              }
          ],
          onAfterCreate : function($dialog, $contentBar) {
            var formOptions = $.extend({}, {
              plugins : [
                {
                  plugin : 'droplist',
                  options : {
                    key : i18nKey + 'newsTemplate',
                    name : 'templateCode',
                    validator : true,
                    param : {
                      categoryCode : 'NEWS_TEMPLATE'
                    }
                  }
                }
              ]
            }, {
              $appendTo : $contentBar
            });
            LK.UI.form(formOptions);
          }
        }));

      }
    }
  ],
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
        plugin : 'droplist',
        options : {
          name : 'usingStatus',
          param : {
            categoryCode : 'NEWS_USING_STATUS',
            includes : 'STAND_BY' + LK.SPLITOR + 'USING'
          }
        }
      }, {
        plugin : 'textbox',
        options : {
          name : 'title',
          cls : 'fuzzy-left fuzzy-right'
        }
      }
  ]
}));
