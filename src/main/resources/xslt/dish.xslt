<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>dish</title>
            </head>
            <body>
                <h1>view dish</h1>
                <p/>
                <a href="/api/v2/dish/all">go to all dishes</a>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="DishDTO">
        <div>
            <p>
                <div>id :
                    <xsl:value-of select="uniqueId"/>
                </div>
            </p>
            <p>
                <div>created at :
                    <xsl:value-of select="createdTimestamp"/>
                </div>
            </p>
            <p>
                <div>modified at :
                    <xsl:value-of select="modifiedTimestamp"/>
                </div>
            </p>
            <p>
                <div>name :
                    <xsl:value-of select="name"/>
                </div>
            </p>
            <p>
                <div>recipe :
                    <xsl:value-of select="recipe"/>
                </div>
            </p>
            <p>
                <div>portion :
                    <xsl:value-of select="portion"/>
                </div>
            </p>
            <p>
                <div>min time :
                    <xsl:value-of select="timeMin"/>
                </div>
            </p>
            <p>
                <div>max time :
                    <xsl:value-of select="timeMax"/>
                </div>
            </p>
        </div>
        <p>ingredients :</p>
        <xsl:for-each select="ingredients/ingredients">
            <div>name :
                <xsl:value-of select="ingredientName"/>
            </div>
            <div>volume :
                <xsl:value-of select="volume"/>
            </div>
            <div>unit :
                <xsl:value-of select="unitName"/>
            </div>
            <p/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>