/*
 * Copyright 2007 Tim Wood
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.flamingpenguin.jewel.cli;

class ParsedOptionSummary
{
    private final ParsedOptionSpecification m_option;

    public ParsedOptionSummary(final ParsedOptionSpecification option)
    {
        m_option = option;
    }

    private boolean hasCustomPattern()
    {
        return !m_option.getPattern().equals(".*");
    }

    private StringBuilder getSummary(final StringBuilder result)
    {
        if (m_option.isOptional())
        {
            result.append("[");
        }

        String sepatator = "";
        for (final String longName : m_option.getLongName()) {
            result.append(sepatator).append("--").append(longName);
            sepatator = " ";
        }

        for (final String shortName : m_option.getShortNames())
        {
            result.append(" -").append(shortName);
        }

        if (m_option.hasValue())
        {
            if (hasCustomPattern())
            {
                result.append(" /").append(m_option.getPattern()).append("/");
            }
            else
            {
                result.append(" value");
            }
            if (m_option.isMultiValued())
            {
                result.append("...");
            }
        }

        if (m_option.isOptional())
        {
            result.append("]");
        }

        return result;
    }

    private boolean nullOrBlank(final String description)
    {
        return description == null || description.trim().equals("");
    }

    @Override public String toString()
    {
        final StringBuilder result = new StringBuilder();

        getSummary(result);

        if (!nullOrBlank(m_option.getDescription()))
        {
            result.append(" : ").append(m_option.getDescription());
        }

        return result.toString();
    }
}
