<#include "/macro/html-lichkin-simple.ftl"/>

<@html css=true js=false;section>
  <#if section="body-content">
      <#if entity.linkUrl?default("")?trim?length == 0>
        <div class="bannerHeader">
        	<div class="bannerTitle">${entity.title}</div>
        	<div class="bannerPublishTime">${entity.publishTime}</div>
        </div>
        <div class="bannerContent">
      	   <div class="bannerContentInfo">${entity.content}</div>
        </div>
      <#else>
        <iframe id="contentIframe" src="${entity.linkUrl}" width="100%" frameborder=0></iframe>
            <script type="text/javascript">
               document.getElementById('contentIframe').height="100%";
        	</script>
      </#if>
  </#if>
</@html>
