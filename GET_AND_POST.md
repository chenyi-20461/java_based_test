<table><thead><tr><th>分类</th><th>GET</th><th>POST</th></tr></thead><tbody><tr><td>后退按钮/刷新</td><td>无害</td><td>数据会被重新提交&#xff08;浏览器应该告知用户数据会被重新提交&#xff09;。</td></tr><tr><td>书签</td><td>可收藏为书签</td><td>不可收藏为书签</td></tr><tr><td>缓存</td><td>能被缓存</td><td>不能缓存</td></tr><tr><td>编码类型</td><td>application/x-www-form-urlencoded</td><td>application/x-www-form-urlencoded 或 multipart/form-data。为二进制数据使用多重编码。</td></tr><tr><td>历史</td><td>参数保留在浏览器历史中。</td><td>参数不会保存在浏览器历史中。</td></tr><tr><td>对数据长度的限制</td><td>是的。当发送数据时&#xff0c;GET 方法向 URL 添加数据&#xff1b;URL 的长度是受限制的&#xff08;URL 的最大长度是 2048 个字符&#xff09;。</td><td>无限制。</td></tr><tr><td>对数据类型的限制</td><td>只允许 ASCII 字符。</td><td>没有限制。也允许二进制数据。</td></tr><tr><td>安全性</td><td>与 POST 相比&#xff0c;GET 的安全性较差&#xff0c;因为所发送的数据是 URL 的一部分。在发送密码或其他敏感信息时绝不要使用 GET &#xff01;</td><td>POST 比 GET 更安全&#xff0c;因为参数不会被保存在浏览器历史或 web 服务器日志中。</td></tr><tr><td>可见性</td><td>数据在 URL 中对所有人都是可见的。</td><td> <p>数据不会显示在 URL 中。</p> </td></tr></tbody></table>
  
  Get方法的长度限制是怎么回事?  
  首先说明这一点，HTTP协议没有body和url的长度限制，对url限制的大多是浏览器和服务器的原因。
服务器是因为处理长url要消耗比较多的资源，为了性能和安全（防止恶意构造长url来攻击）考虑，会给url长度加限制  
<br/>get能传body体。

硬币 | 数量
--- | :---
五毛 | 3
一角 | 5

硬币 | 数量
--- | ---:
五毛 | 3
一角 | 5

硬币 | 数量
--- | :---:
五毛 | 3
一角 | 5


