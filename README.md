<h1><a id="EasyNetworkViews_0"></a>EasyNetworkViews</h1>
<p>This library provides an easier way to manage your progress,content and error layouts so you dont have to nest layouts under layouts</p>
<h2><a id="Usage_2"></a>Usage</h2>
<p>implementation ‘com.klepto:easynetworkviews:1.0.0’</p>
<p>Add the xml to your root layout<br>
<code>&lt;com.klepto.easynetworkviews.EasyNetworkViews android:layout_width=&quot;match_parent&quot; android:layout_height=&quot;match_parent&quot; android:id=&quot;@+id/easyViews&quot;/&gt;</code></p>
<p>Now in your class file use<br>
<code>easyViews.setContentLayout(R.layout.content) easyViews.showProgress(true) Thread { Thread.sleep(2000) runOnUiThread { easyViews.showContent() } }.start()</code></p>
<p>It will throw an error if you have not set your content layout. It has a default error layout that just shows a toast message and a basic progress layout.</p>
