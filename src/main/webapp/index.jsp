 <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="description" content="Pixelizator">
    <meta name="keywords" content="HTML, CSS, JavaScript, java, ucode, unitfactory, cbl, cblworld,
                                    pixelize, pixelizer, pixelizator">
    <meta name="author" content="Tetiana Rohalska">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Pixelizator</title>
    <link rel="shortcut icon" href="http://localhost:8080/pixelizator/favicon.ico" type="image/x-icon"/>
    <link rel="icon" href="http://localhost:8080/pixelizator/favicon.ico" type="image/x-icon"/>
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet"/>
    <link rel="stylesheet" href="styles.css"/>
</head>

<body>

<h1>Pixelizator && Fun Filters</h1>

<p id="description">This website helps you in couple clicks pixelize your picture in different ways!</p>

<div class="box">
    <label class="headers">Load image</label>
    <input id="inputFile" class="buttons" type="file" accept="image/*" onchange="upload(this)">
    <input id="fileClear" class="buttons" type="button" value="clear">
</div>

<div class="box">
    <label class="headers">Filters</label>
    <label><input type="radio" class="filters" name="filters" value="0" checked="checked">none</label>
    <label><input type="radio" class="filters" name="filters" value="1">gray</label>
    <label><input type="radio" class="filters" name="filters" value="2">red</label>
    <label><input type="radio" class="filters" name="filters" value="3">window</label>
    <label><input type="radio" class="filters" name="filters" value="4">rainbow</label>
</div>

<div class="box">
    <label class="headers">Pixelize figure</label>
    <label><input type="radio" class="algorithms" name="algorithms" value="0" checked="checked">rectangle</label>
    <label><input type="radio" class="algorithms" name="algorithms" value="1">triangle</label>
</div>

<div class="box">
    <label class="headers">Block size(px)</label>
    <input type="range" class="choice" id="pixRange" min="1" max="100" value="10">
    <label id="outNumber">x10</label>
    <input id="pixelize" class="buttons" type="button" value="pixelize">
</div>

<div class="box">
    <label class="headers">Download image</label>
    <input class="download" type="button" value="jpg">
    <input class="download" type="button" value="png">
      <input class="download" type="button" value="webp">
    <input class="download" type="button" value="bmp">
    <input class="download" type="button" value="tiff">
    <input class="download" type="button" value="gif">
</div>

<br>

<div class="imgBox">
    <div class="images">
        <img id="inputImg" src="#" alt="input image">

        <div class="info">
            <p id="name"></p>
            <p id="format"></p>
            <p id="size"></p>
            <p id="resolution"></p>
        </div>

    </div>
    <div class="images">
        <img id="resultImg" src="#" alt="result image">
    </div>
</div>

<script src="script.js"></script>

</body>
</html>