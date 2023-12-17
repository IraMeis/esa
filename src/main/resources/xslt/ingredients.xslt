<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>ingredient</title>
            </head>
            <body>
                <h1>all ingredients</h1>
                <table>
                    <thead>
                        <tr>
                            <td>№</td>
                            <td>name</td>
                            <td>id</td>
                            <td>created</td>
                            <td>modified</td>
                        </tr>
                    </thead>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="ArrayList">
        <tbody>
            <xsl:for-each select="item">
                <tr>
                    <xsl:variable name="i" select="position()"/>
                    <td>
                        <xsl:value-of select="$i" />
                    </td>
                    <td>
                        <xsl:element name="a">
                            <xsl:attribute name="href">
                                <xsl:value-of select="uniqueId"/>
                            </xsl:attribute>
                            <xsl:value-of select="name"/>
                        </xsl:element>
                    </td>
                    <td>
                        <xsl:value-of select="uniqueId"/>
                    </td>
                    <td>
                        <xsl:value-of select="createdTimestamp"/>
                    </td>
                    <td>
                        <xsl:value-of select="modifiedTimestamp"/>
                    </td>
                </tr>
            </xsl:for-each>
        </tbody>
    </xsl:template>
</xsl:stylesheet>