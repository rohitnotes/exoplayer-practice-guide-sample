package com.takusemba.exobook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.takusemba.exobook.core.AesSampleActivity
import com.takusemba.exobook.core.BasicSampleActivity
import com.takusemba.exobook.core.CaptionSampleActivity
import com.takusemba.exobook.core.CustomizeSampleActivity
import com.takusemba.exobook.core.DebugSampleActivity
import com.takusemba.exobook.core.DownloadSampleActivity
import com.takusemba.exobook.core.DrmSampleActivity
import com.takusemba.exobook.core.MetadataSampleActivity
import com.takusemba.exobook.core.UiSampleActivity
import com.takusemba.exobook.extension.CastSampleActivity
import com.takusemba.exobook.extension.CodecSampleActivity
import com.takusemba.exobook.extension.ImaSampleActivity
import com.takusemba.exobook.extension.LeanbackSampleActivity
import com.takusemba.exobook.extension.MediaSessionSampleActivity
import com.takusemba.exobook.extension.NetworkSampleActivity
import com.takusemba.exobook.extension.RtmpSampleActivity
import com.takusemba.exobook.extension.SchedulerSampleActivity

class SampleAdapter : BaseExpandableListAdapter() {

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
        val (title, _) = getGroup(groupPosition)
        (view as TextView).text = title
        return view
    }

    override fun getGroup(groupPosition: Int): SampleGroup {
        return SAMPLE_GROUPS[groupPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return SAMPLE_GROUPS.size
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        val sample = getChild(groupPosition, childPosition)
        view.findViewById<TextView>(android.R.id.text1).text = sample.title
        return view
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Sample {
        val (_, samples) = getGroup(groupPosition)
        return samples[childPosition]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        val (_, samples) = getGroup(groupPosition)
        return samples.size
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    companion object {

        val SAMPLE_GROUPS = listOf(
            SampleGroup(
                "Core Library",
                listOf(
                    Sample("Chapter 3 (Basic)", BasicSampleActivity::class.java),
                    Sample("Chapter 4 (Caption)", CaptionSampleActivity::class.java),
                    Sample("Chapter 5 (Metadata)", MetadataSampleActivity::class.java),
                    Sample("Chapter 6 (UI)", UiSampleActivity::class.java),
                    Sample("Chapter 7 (AES)", AesSampleActivity::class.java),
                    Sample("Chapter 8 (DRM)", DrmSampleActivity::class.java),
                    Sample("Chapter 9 (Customize)", CustomizeSampleActivity::class.java),
                    Sample("Chapter 10 (Download)", DownloadSampleActivity::class.java),
                    Sample("Chapter 11 (Debug)", DebugSampleActivity::class.java)
                )
            ),
            SampleGroup(
                "Extension Library",
                listOf(
                    Sample("Chapter 1 (IMA)", ImaSampleActivity::class.java),
                    Sample("Chapter 2 (Cast)", CastSampleActivity::class.java),
                    Sample("Chapter 3 (MediaSession)", MediaSessionSampleActivity::class.java),
                    Sample("Chapter 4 (Network)", NetworkSampleActivity::class.java),
                    Sample("Chapter 5 (Codec)", CodecSampleActivity::class.java),
                    Sample("Chapter 6 (Scheduler)", SchedulerSampleActivity::class.java),
                    Sample("Chapter 7 (RTMP)", RtmpSampleActivity::class.java),
                    Sample("Chapter 8 (Leanback)", LeanbackSampleActivity::class.java)
                )
            )
        )
    }
}