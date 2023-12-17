<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>ingredient</title>
            </head>
            <body>
                <h1>view ingredient</h1>
                <p/>
                <a href="/api/v2/ingredient/all">go to all ingredients</a>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="IngredientDTO">
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
        </div>
    </xsl:template>
</xsl:stylesheet>