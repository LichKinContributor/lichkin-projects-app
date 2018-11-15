<#include "/macro/html-lichkin-simple.ftl"/>

<@html css=true js=false;section>
  <#if section="body-content">
    <#if entity.linkUrl?default("")?trim?length == 0>
    	<div>${entity.title}</div>
    	<div>${entity.publishTime}</div>
    	<div>${entity.content}</div>
    <#else>
      <iframe id="contentIframe" src="${entity.linkUrl}" width="100%" frameborder=0></iframe>
        <script type="text/javascript">
             document.getElementById('contentIframe').height="100%";
      	</script>
    </#if>
  </#if>
</@html>
